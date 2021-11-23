package com.liu.service;

import com.liu.mapper.SchedulingMapper;
import com.liu.pojo.Scheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 排产子表Service实现类
 */
@Service
public class SchedulingServiceImpl implements SchedulingService{
    @Autowired
    private SchedulingMapper mapper;

    @Override
    public List<Scheduling> queryAllSchedulings() {
        return mapper.queryAllSchedulings();
    }

    @Override
    public int addScheduling(Scheduling scheduling) {
        return mapper.addScheduling(scheduling);
    }

    @Override
    public int deleteScheduling(String id) {
        return mapper.deleteScheduling(id);
    }

    @Override
    public int updateScheduling(Scheduling scheduling) {
        return mapper.updateScheduling(scheduling);
    }
}
