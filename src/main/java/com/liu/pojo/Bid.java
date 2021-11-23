package com.liu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 竞标实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bid {
    private String id;
    private Order order;
    private String orderid;
    private String orderno;
    private Factory factory;
    private String factoryid;
    private int bidprice;
    private int bidstatus;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date update_time;
}
