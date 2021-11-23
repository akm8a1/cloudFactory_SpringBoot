package com.liu.mapper;

import com.liu.pojo.SchedulingChild;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 排产子表Mapper
 */
@Mapper
@Repository
public interface SchedulingChildMapper {
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
     * @param schedulingChild
     * @return
     */
    /*修改*/
    int updateSchedulingChild(SchedulingChild schedulingChild);

    /**
     * 总数
     * @return
     */
    int getCounts();
}
