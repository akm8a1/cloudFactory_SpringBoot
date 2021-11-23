package com.liu.mapper;

import com.liu.pojo.Scheduling;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 排产Mapper
 */
@Mapper
@Repository
public interface SchedulingMapper {
    /*获取全部Scheduling*/
    List<Scheduling> queryAllSchedulings();
    /*新增*/
    int addScheduling(Scheduling scheduling);
    /*删除*/
    int deleteScheduling(@Param("id")String id);
    /*修改*/
    int updateScheduling(Scheduling scheduling);
    /*总数*/
    int getCounts();
}
