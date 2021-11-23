package com.liu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用作前端传值的工具类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddPojo {
    private String userid;
    private String login_name;
    private String user_name;
    private String password;
    private String mobile;
    private Role role;
    private String roleid;
    private String email;
    private String factoryid;
    private String factoryname;
    private String factorydetail;
    private int status;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date update_time;
}
