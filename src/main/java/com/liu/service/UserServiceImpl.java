package com.liu.service;

import com.liu.mapper.UserMapper;
import com.liu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户Service实现类
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String username, String password) {
        return userMapper.login(username,password);
    }

    @Override
    public int getUserCounts() {
        return userMapper.getUserCounts();
    }

    @Override
    public int getAdmins() {
        return userMapper.getAdmins();
    }

    @Override
    public int getFactorys() {
        return userMapper.getFactorys();
    }

    @Override
    public int getTraders() {
        return userMapper.getTraders();
    }

    @Override
    public List<User> queryUsers() {
        return userMapper.queryUsers();
    }

    @Override
    public User queryUserById(String id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(String id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public List<User> queryUsersByListName(String likename) {
        return userMapper.queryUsersByListName(likename);
    }

    @Override
    public List<String> getUserIdByOrderAndBid(String orderid) {
        return userMapper.getUserIdByOrderAndBid(orderid);
    }
}
