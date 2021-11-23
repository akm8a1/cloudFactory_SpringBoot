package com.liu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 用作前端传值的 订单、竞标实体类
 */
public class BidAndOrder {
    private String factoryid;
    private String orderid;
    private String bidid;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date update_time;
}
