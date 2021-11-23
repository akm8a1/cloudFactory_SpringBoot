package com.liu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 订单实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String id;
    private String orderno;
    private String ordernum;
    private Product product;
    private String productid;
    private String deaddate;
    private String deliverDate;
    private int orderstatus;
    private Factory factory;
    private String factoryid;
    private Contact_address_tab contact;
    private String contact_id;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date update_time;
    private String orderStatus_name;
    private String trader_id;
}