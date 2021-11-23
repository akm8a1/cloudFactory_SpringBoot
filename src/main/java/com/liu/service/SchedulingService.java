package com.liu.service;

import com.liu.pojo.Scheduling;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 排产子表Service接口
 */
public interface SchedulingService {
    /**
     * 获取全部Scheduling
     * @return
     */
    List<Scheduling> queryAllSchedulings();

    /**
     * 新增
     * @param scheduling
     * @return
     */
    int addScheduling(Scheduling scheduling);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteScheduling(@Param("id")String id);

    /**
     * 修改
     * @param scheduling
     * @return
     */
    int updateScheduling(Scheduling scheduling);
}
