package com.liu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 * 邮件Service
 */
@Service
public class EmailService {
    @Autowired
    private  JavaMailSenderImpl mailSender;
    public void sendMail(String text,String toAddress){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("2661190790@qq.com");
        simpleMailMessage.setTo(toAddress);
        simpleMailMessage.setSubject("云工厂系统邮件");
        simpleMailMessage.setText(text);
        mailSender.send(simpleMailMessage);
    }
}
