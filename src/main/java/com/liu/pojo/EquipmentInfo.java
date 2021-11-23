package com.liu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 设备信息实体类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentInfo {
    private String id;
    private String equip_code;
    private String detail;
    private int status;
    private int rentstatus;
    private EquipmentCategory equipmentCategory;
    private String equipmentcate_id;
    private String factory_id;
    private Factory factory;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date update_time;
    private String status_name;
    private String rentstatus_name;
}
