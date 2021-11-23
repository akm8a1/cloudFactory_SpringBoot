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
public class SchedulingAndChild {
    private String scheduling_id;
    private String orderid;
    private String begindate;
    private String enddate;
    private Date beginProduceDate;
    private Date endProduceDate;
    private String factoryid;
    private String equipment_id;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date update_time;
}
