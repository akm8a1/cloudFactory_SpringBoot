package com.liu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 排产子表实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingChild {
    private String id ;
    private Date begindate;
    private Date enddate;
    private EquipmentInfo equipmentInfo;
    private String equipment_id;
    private String main_id;
    private Scheduling scheduling;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date update_time;
}
