package com.liu.service;

import com.liu.pojo.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 日志记录Service接口
 */
public interface LogService {
    /**
     * 获取所有的消息记录
     * @return
     */
    List<Log> queryAllLogs();

    /**
     * 根据用户id获取所有的消息记录
     * @param id
     * @return
     */
    List<Log> queryAllLogsByUserId(@Param("id") String id);

    /**
     * 增加一条记录
     * @param log
     * @return
     */
    int addLog(Log log);

    /**
     * 删除一条记录
     * @param id
     * @return
     */
    int deleteLog(@Param("id")String id);

    /**
     * 更改记录的状态
     * @param log
     * @return
     */
    int updateLog(Log log);

    /**
     * 删除给某用户的所有记录
     * @param id
     * @return
     */
    int deleteAllLogsByUserId(@Param("id")String id);

    /**
     * 根据touserid返回所有的状态为status的信息
     * @param touserid
     * @param status
     * @return
     */
    List<Log> queryLogsByStatusAndId(@Param("touserid")String touserid,@Param("status")int status);

    /**
     * 给某用户的所有状态为status的记录做批量修改
     * @param id
     * @param status
     * @param newstatus
     * @return
     */
    int updateAllLogs(String id,int status,int newstatus);

    /**
     * 3的日志
     * @param id
     * @return
     */
    int deletDeletedLogsByUserId(String id);
}
