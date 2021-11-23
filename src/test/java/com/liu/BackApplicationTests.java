package com.liu;


import com.liu.mapper.UserMapper;
import com.liu.service.UserService;
import com.liu.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BackApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Autowired
    private EmailService service;
    @Test
    void contextLoads() {
        List<String> list = userService.getUserIdByOrderAndBid("6f42d79d80b5488e8dda731db34e7386");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
