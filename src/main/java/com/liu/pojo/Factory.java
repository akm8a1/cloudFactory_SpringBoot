package com.liu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 云工厂实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factory {
    private String id;
    private String name;
    private String detail;
    private int status;
    private String user_id;
    private String user_name;
    private String mobile;
    private String status_name;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date update_time;
}
