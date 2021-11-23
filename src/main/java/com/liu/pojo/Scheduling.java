package com.liu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 排产实体类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Scheduling {
    private String id;
    private Order order;
    private String orderid;
    private Factory factory;
    private String factoryid;
    private String begindate;
    private String enddate;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date update_time;
}
