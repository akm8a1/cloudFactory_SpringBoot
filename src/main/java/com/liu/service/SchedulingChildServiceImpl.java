package com.liu.service;

import com.liu.mapper.SchedulingChildMapper;
import com.liu.pojo.SchedulingChild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 排产Service实现类
 */
@Service
public class SchedulingChildServiceImpl implements SchedulingChildService{
    @Autowired
    private SchedulingChildMapper mapper;
    @Override
    public List<SchedulingChild> queryAllSchedulingChilds() {
        return mapper.queryAllSchedulingChilds();
    }

    @Override
    public int addSchedulingChild(SchedulingChild schedulingChild) {
        return mapper.addSchedulingChild(schedulingChild);
    }

    @Override
    public int deleteSchedulingChild(String id) {
        return mapper.deleteSchedulingChild(id);
    }

    @Override
    public int updateSchedulingChild(SchedulingChild schedulingChild) {
        return mapper.updateSchedulingChild(schedulingChild);
    }
}
