package com.liu.service;

import com.liu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户Service接口
 */
public interface UserService {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User login(@Param("login_name") String username, @Param("password") String password);

    /**
     * 获取用户数量
     * @return
     */
    int getUserCounts();

    /**
     * 获取超级管理员数
     * @return
     */
    int getAdmins();

    /**
     * 获取云工厂管理员数
     * @return
     */
    int getFactorys();

    /**
     * 获取经销商数量
     * @return
     */
    int getTraders();

    /**
     * 查询所有的用户
     * @return
     */
    List<User> queryUsers();

    /**
     * 通过id查询单个用户
     * @param id
     * @return
     */
    User queryUserById(@Param("id") String id);

    /**
     * 修改一个用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 通过id删除一个用户
     * @param id
     * @return
     */
    int deleteUser(@Param("id") String id);

    /**
     * 新增一个用户
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 根据姓名模糊查询
     * @param likename
     * @return
     */
    List<User> queryUsersByListName(String likename);

    /**
     * 根据订单id找出所有参与了该订单竞标的云工厂管理员
     * @param orderid
     * @return
     */
    List<String> getUserIdByOrderAndBid(@Param("orderid")String orderid);
}
