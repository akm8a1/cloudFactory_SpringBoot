package com.liu.service;

import com.liu.pojo.SchedulingChild;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 排产Service接口
 */
public interface SchedulingChildService {
    /**
     * 获取全部SchedulingChild
     * @return
     */
    List<SchedulingChild> queryAllSchedulingChilds();

    /**
     * 新增
     * @param schedulingChild
     * @return
     */
    int addSchedulingChild(SchedulingChild schedulingChild);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteSchedulingChild(@Param("id")String id);

    /**
     * 修改
     * @param schedulingChild
     * @return
     */
    int updateSchedulingChild(SchedulingChild schedulingChild);
}
