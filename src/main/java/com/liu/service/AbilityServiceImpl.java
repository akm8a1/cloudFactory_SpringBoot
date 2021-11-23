package com.liu.service;

import com.liu.mapper.AbilityMapper;
import com.liu.pojo.Ability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产能配置Service实现类
 */
@Service
public class AbilityServiceImpl implements AbilityService{
    @Autowired
    private AbilityMapper mapper;
    @Override
    public List<Ability> queryAllAbilities() {
        return mapper.queryAllAbilities();
    }

    @Override
    public int addAbility(Ability ability) {
        return mapper.addAbility(ability);
    }

    @Override
    public int deleteAbility(String id) {
        return mapper.deleteAbility(id);
    }

    @Override
    public int updateAbility(Ability ability) {
        return mapper.updateAbility(ability);
    }
}
