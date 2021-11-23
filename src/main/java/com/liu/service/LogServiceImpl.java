package com.liu.service;

import com.liu.mapper.LogMapper;
import com.liu.pojo.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 日志记录Service实现类
 */
@Service
public class LogServiceImpl implements LogService{
    @Autowired
    private LogMapper mapper;

    @Override
    public List<Log> queryAllLogs() {
        return mapper.queryAllLogs();
    }

    @Override
    public List<Log> queryAllLogsByUserId(String id) {
        return mapper.queryAllLogsByUserId(id);
    }

    @Override
    public int addLog(Log log) {
        return mapper.addLog(log);
    }

    @Override
    public int deleteLog(String id) {
        return mapper.deleteLog(id);
    }

    @Override
    public int updateLog(Log log) {
        return mapper.updateLog(log);
    }

    @Override
    public int deleteAllLogsByUserId(String id) {
        return mapper.deleteAllLogsByUserId(id);
    }

    @Override
    public List<Log> queryLogsByStatusAndId(String touserid, int status) {
        return mapper.queryLogsByStatusAndId(touserid,status);
    }

    @Override
    public int updateAllLogs(String id, int status, int newstatus) {
        return mapper.updateAllLogs(id,status,newstatus);
    }

    @Override
    public int deletDeletedLogsByUserId(String id) {
        return mapper.deletDeletedLogsByUserId(id);
    }
}
