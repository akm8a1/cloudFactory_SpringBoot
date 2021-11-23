package com.liu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 产能配置实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ability {
    //唯一标识id
    private String id;
    //设备
    private EquipmentInfo equipmentInfo;
    //产品
    private Product product;
    //产能
    private String ability;
    //云工厂
    private Factory factory;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date update_time;
}
