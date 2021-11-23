package com.liu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 记录日志实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    private String id;
    private String fromuserid;
    private String touserid;
    private String thing;
    private int status;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date update_time;
    public Log(String id,String fromuserid,String touserid,String thing,int status) {
        this.id = id;
        this.fromuserid = fromuserid;
        this.touserid = touserid;
        this.status = status;
        this.thing = thing;
    }
}
