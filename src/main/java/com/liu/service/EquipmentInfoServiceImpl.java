package com.liu.service;

import com.liu.mapper.EquipmentInfoMapper;
import com.liu.pojo.EquipmentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 设备Service实现类
 */
@Service
public class EquipmentInfoServiceImpl implements EquipmentInfoService{
    @Autowired
    private EquipmentInfoMapper mapper;
    @Override
    public List<EquipmentInfo> queryAllEquipmentInfos() {
        return mapper.queryAllEquipmentInfos();
    }

    @Override
    public List<EquipmentInfo> queryEquipmentInByNo(String no) {
        return mapper.queryEquipmentInByNo(no);
    }

    @Override
    public int addEquipmentInfo(EquipmentInfo equipmentInfo) {
        return mapper.addEquipmentInfo(equipmentInfo);
    }

    @Override
    public int updateEquipmentInfo(EquipmentInfo equipmentInfo) {
        return mapper.updateEquipmentInfo(equipmentInfo);
    }

    @Override
    public int deleteEquipmentInfo(String id) {
        return mapper.deleteEquipmentInfo(id);
    }

    @Override
    public List<EquipmentInfo> queryAllEquipmentInfosByUserId(String id) {
        return mapper.queryAllEquipmentInfosByUserId(id);
    }

    @Override
    public List<EquipmentInfo> queryAllEquipmentInfoRenable() {
        return mapper.queryAllEquipmentInfoRenable();
    }

    @Override
    public int rentOrback(EquipmentInfo equipmentInfo) {
        return mapper.rentOrback(equipmentInfo);
    }

    @Override
    public int updateStatus(int status,String id) {
        return mapper.updateStatus(status,id);
    }

    @Override
    public List<EquipmentInfo> queryAllEquipsWithOrder(String id) {
        return mapper.queryAllEquipsWithOrder(id);
    }

    @Override
    public int getCounts() {
        return mapper.getCounts();
    }
}
