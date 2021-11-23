package com.liu.service;

import com.liu.mapper.EquipmentCategoryMapper;
import com.liu.pojo.EquipmentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 设备类别Service实现类
 */
@Service
public class EquipmentCategoryServiceImpl implements EquipmentCategoryService{
    @Autowired
    private EquipmentCategoryMapper mapper;
    @Override
    public List<EquipmentCategory> queryAllEquipmentCategories() {
        return mapper.queryAllEquipmentCategories();
    }

    @Override
    public List<EquipmentCategory> queryEquipmentCategoryByName(String likename) {
        return mapper.queryEquipmentCategoryByName(likename);
    }

    @Override
    public int addEquipmentCategory(EquipmentCategory equipmentCategory) {
        return mapper.addEquipmentCategory(equipmentCategory);
    }

    @Override
    public int updateEquipmentCategory(EquipmentCategory equipmentCategory) {
        return mapper.updateEquipmentCategory(equipmentCategory);
    }

    @Override
    public int deleteEquipmentCategory(String id) {
        return mapper.deleteEquipmentCategory(id);
    }

    @Override
    public int getCounts() {
        return mapper.getCounts();
    }

    @Override
    public int getEquipmentCounts(String id) {
        return mapper.getEquipmentCounts(id);
    }

    @Override
    public int getEquipmentFactoryCounts(String id, String factoryid) {
        return mapper.getEquipmentFactoryCounts(id,factoryid);
    }
}
