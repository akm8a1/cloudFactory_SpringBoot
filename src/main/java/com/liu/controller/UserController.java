package com.liu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.liu.pojo.Factory;
import com.liu.pojo.Log;
import com.liu.pojo.User;
import com.liu.pojo.UserAddPojo;
import com.liu.service.FactoryService;
import com.liu.service.LogService;
import com.liu.service.UserService;
import com.liu.service.EmailService;
import com.liu.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * @author 陆源东
 * 用户Controller
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private FactoryService factoryService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private LogService logService;

    /**
     * 分页查询用户
     * @param pageCode
     * @param pageSize
     * @return
     */
    @GetMapping("/users/{pageCode}/{pageSize}")
    public PageInfo<User> queryUsers(@PathVariable int pageCode,@PathVariable  int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize,true);
        //调用分页查询方法，mybaits自动进行分页的计算
        List<User> users = userService.queryUsers();
        return new PageInfo<>(users);
    }

    /**
     * 登录
     * @param session
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login/{login_name}/{password}")
    public User login(HttpSession session,@PathVariable("login_name") String username,@PathVariable("password") String password) {
        User user = userService.login(username,password);
        if (user != null) {
            session.setAttribute("CURRENT_USER",user);
        }
        return user;
    }

    /**
     * 获取用户总数
     * @return
     */
    @RequestMapping("/getUserCount")
    public int getUserCounts() {
        return userService.getUserCounts();
    }

    /**
     * 获取超级管理员数
     * @return
     */
    @RequestMapping("/getAdminCount")
    public int getAdminCounts() {
        return userService.getAdmins();
    }

    /**
     * 获取云工厂管理员数量
     * @return
     */
    @RequestMapping("/getFactoryCount")
    public int getFactorys() {
        return userService.getFactorys();
    }

    /**
     * 获取经销商数据
     * @return
     */
    @RequestMapping("/getTraderCount")
    public int getTraders() {
        return userService.getTraders();
    }

    /**
     * 增加用户
     * @param userInfo
     * @return
     */
    @RequestMapping("/addUser")
    public boolean addUser(@RequestBody UserAddPojo userInfo) {
        String userid = Utils.getUUID();
        User user = new User(userid,userInfo.getLogin_name(),userInfo.getUser_name(),
                userInfo.getPassword(),userInfo.getMobile(),null,userInfo.getRoleid(),
                userInfo.getEmail(),userInfo.getCreate_time(),userInfo.getUpdate_time());
        int result  = userService.insertUser(user);
        new Thread(){
            @Override
            public void run() {
                Log log = new Log(Utils.getUUID(),Utils.getAdminId(),userid,"您的账号已被创建,云工厂欢迎您的使用",1);
                logService.addLog(log);
            }
        }.start();
        if(result<=0)  {return false;}
        if (!StringUtil.isEmpty(userInfo.getFactoryname())) {
            Factory factory = new Factory(Utils.getUUID(),userInfo.getFactoryname(),userInfo.getFactorydetail(),
                    userInfo.getStatus(),userid,userInfo.getUser_name(),userInfo.getMobile(),null,
                    userInfo.getCreate_time(),userInfo.getUpdate_time());
            result = factoryService.addFactory(factory);
        }
        new Thread() {
            @Override
            public void run() {
                if (!StringUtil.isEmpty(userInfo.getEmail())) {
                    emailService.sendMail("您在云工厂中的账号已被创建,\n登陆账号为:"+
                            userInfo.getLogin_name()+"\n"+"登录密码为:"+userInfo.getPassword(),userInfo.getEmail());
                }
            };
        }.start();
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping("/deleteUser/{id}")
    public boolean deleteUser(@PathVariable("id") String id) {
        logService.deleteAllLogsByUserId(id);
        User user = userService.queryUserById(id);
        int result = 0 ;
        if (user == null) {return false;}
        if (user.getRole().getId().equals("3")) {
            //经销商
            result = userService.deleteUser(id);
            if (result<=0) {return false;}
        } else if(user.getRole().getId().equals("2")) {
            System.out.println(user);
            //云工厂
            Factory factory = factoryService.queryFactoryByUserId(id);
            System.out.println(factory);
            result = factoryService.deleteFactory(factory.getId());
            if (result<=0) {return false;}
            result = userService.deleteUser(id);
        }
        new Thread() {
            @Override
            public void run() {
                if (!StringUtil.isEmpty(user.getEmail())) {
                    emailService.sendMail("您在云工厂中的账号已被注销",user.getEmail());
                }
            };
        }.start();
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    public boolean updateUser(@RequestBody User user) {
        System.out.println(user);
        int result = userService.updateUser(user);
        new Thread() {
            @Override
            public void run() {
                if (!StringUtil.isEmpty(user.getEmail())) {
                    emailService.sendMail("您在云工厂中的账号信息已被修改," +
                            "\n请登录以查看具体信息",user.getEmail());
                }
            };
        }.start();
        new Thread(){
            @Override
            public void run() {
                Log log = new Log(Utils.getUUID(),Utils.getAdminId(),user.getId(),"您的账号已被修改，请关注",1);
                logService.addLog(log);
            }
        }.start();
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据姓名模糊查找
     * @param name
     * @return
     */
    @RequestMapping("/search/{likename}")
    public List<User> queryUsersByLikeName(@PathVariable("likename") String name) {
        System.out.println(name);
        return userService.queryUsersByListName(name);
    }
}
