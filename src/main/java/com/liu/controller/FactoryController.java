package com.liu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.pojo.Factory;
import com.liu.pojo.Log;
import com.liu.pojo.User;
import com.liu.service.FactoryService;
import com.liu.service.LogService;
import com.liu.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author 陆源东
 * 云工厂Controller
 */
@RestController
public class FactoryController {
    @Autowired
    private FactoryService factoryService;
    @Autowired
    private LogService logService;

    /**
     * 所有的Factory（分页）
     * @param pageCode
     * @param pageSize
     * @return
     */
    @GetMapping("/factory/{pageCode}/{pageSize}")
    public PageInfo<Factory> queryFactorys(@PathVariable int pageCode, @PathVariable  int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize,true);
        //调用分页查询方法，mybaits自动进行分页的计算
        List<Factory> factories = factoryService.queryFactorys();
        return new PageInfo<>(factories);
    }
    /*增加Factory*/
    @RequestMapping("/addFactory")
    public boolean addFactory(@RequestBody Factory factory) {
        factory.setId(Utils.getUUID());
        int result = factoryService.addFactory(factory);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除Factory
     * @param id
     * @return
     */
    @RequestMapping("/deleteFactory/{id}")
    public boolean deleteFactory(@PathVariable("id") String id) {
        System.out.println(id);
        int result = factoryService.deleteFactory(id);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改Factory
     * @param factory
     * @return
     */
    /*修改Factory*/
    @RequestMapping("/updateFactory")
    public boolean updateFactory(@RequestBody Factory factory) {
        System.out.println(factory);
        int result = factoryService.updateFactory(factory);
        new Thread(){
            @Override
            public void run() {
                Log log = new Log(Utils.getUUID(),Utils.getAdminId(),factory.getUser_id(),"您的工厂信息被修改，请关注",1);
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
     * 根据名字模糊查找Factory
     * @param name
     * @return
     */
    @RequestMapping("/searchFactory/{likename}")
    public List<Factory> queryFactoryByLikeName(@PathVariable("likename") String name) {
        System.out.println(name);
        return factoryService.queryFactoryByLikeName(name);
    }

    /**
     * 根据userid找工厂
     * @param id
     * @return
     */
    @RequestMapping("/queryFactoryByUserId/{id}")
    public Factory  queryFactoryByUserId(@PathVariable("id") String id) {
        return factoryService.queryFactoryByUserId(id);
    }

    /**
     * 工厂自己改变状态
     * @param factory
     * @return
     */
    @RequestMapping("/updateFactoryStatus")
    public boolean updateFactoryStatus(@RequestBody Factory factory) {
        int result = factoryService.updateFactory(factory);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据订单id找工厂
     * @param id
     * @return
     */
    @RequestMapping("/queryFactoryByOrderId/{orderid}")
    public Factory  queryFactoryById(@PathVariable("orderid") String id) {
        return factoryService.queryFactoryByOrderId(id);
    }
}
