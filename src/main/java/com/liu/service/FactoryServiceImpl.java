package com.liu.service;

import com.liu.mapper.FactoryMapper;
import com.liu.pojo.Factory;
import com.liu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 云工厂Service实现类
 */
/*云工厂Service实现类*/
@Service
public class FactoryServiceImpl implements FactoryService{
    @Autowired
    private FactoryMapper factoryMapper;

    @Override
    public List<Factory> queryFactorys() {
        return factoryMapper.queryFactorys();
    }

    @Override
    public int addFactory(Factory factory) {
        return factoryMapper.addFactory(factory);
    }

    @Override
    public int deleteFactory(String id) {
        return factoryMapper.deleteFactory(id);
    }

    @Override
    public int updateFactory(Factory factory) {
        return factoryMapper.updateFactory(factory);
    }

    @Override
    public List<Factory> queryFactoryByLikeName(String likename) {
        return factoryMapper.queryFactoryByLikeName(likename);
    }

    @Override
    public Factory queryFactoryById(String id) {
        return factoryMapper.queryFactoryById(id);
    }

    @Override
    public Factory queryFactoryByUserId(String id) {
        return factoryMapper.queryFactoryByUserId(id);
    }

    @Override
    public Factory queryFactoryByOrderId(String id) {
        return factoryMapper.queryFactoryByOrderId(id);
    }
}
