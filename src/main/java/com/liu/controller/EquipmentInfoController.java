package com.liu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.pojo.*;
import com.liu.service.EquipmentCategoryService;
import com.liu.service.EquipmentInfoService;
import com.liu.service.FactoryService;
import com.liu.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/**
 * @author 陆源东
 * 设备管理Controller
 */
@RestController
public class EquipmentInfoController {
    @Autowired
    private EquipmentInfoService service;
    @Autowired
    private FactoryService factoryService;
    @Autowired
    private EquipmentCategoryService categoryService;

    /**
     * 获取所有的设备
     * @param userId
     * @param roleid
     * @param pageCode
     * @param pageSize
     * @return
     */
    @GetMapping("/equipments/{pageCode}/{pageSize}/{userId}/{roleid}")
    public PageInfo<EquipmentInfo> queryEquipmentInfos(@PathVariable("userId") String userId,@PathVariable("roleid")String roleid,@PathVariable int pageCode, @PathVariable  int pageSize) {
        //使用Mybatis分页插件
        /*先找到对应的云工厂*/
        Factory factory = factoryService.queryFactoryByUserId(userId);
        String factoryid = factory.getId();
        PageHelper.startPage(pageCode,pageSize,true);
        List<EquipmentInfo> equipmentInfos = null;
        if ("1".equals(roleid)) { //是超级管理员
            equipmentInfos = service.queryAllEquipmentInfos();
        }  else if ("2".equals(roleid)) //云工厂
        {
            equipmentInfos = service.queryAllEquipmentInfosByUserId(factoryid);
        }
        return new PageInfo<>(equipmentInfos);
    }

    /**
     * 获取工厂拥有的所有设备(不分页)
     * @param userId
     * @return
     */
    @GetMapping("/equipments/{userId}")
    public List<EquipmentInfo> queryEquipmentInfos(@PathVariable("userId") String userId) {
        Factory factory = factoryService.queryFactoryByUserId(userId);
        String factoryid = factory.getId();
        return service.queryAllEquipmentInfosByUserId(factoryid);
    }

    /**
     * 查询
     * @param no
     * @return
     */
    @RequestMapping("/searchEquipment/{no}")
    public  List<EquipmentInfo> queryEquipmentInfoByLikeName(@PathVariable("no") String no) {
        return service.queryEquipmentInByNo(no);
    }

    /**
     * 新增
     * @param equipmentInfo
     * @return
     */
    @RequestMapping("/addEquipment")
    public boolean addEquipmentInfo(@RequestBody EquipmentInfo equipmentInfo) {
        equipmentInfo.setId(Utils.getUUID());
        equipmentInfo.setEquip_code(Utils.getEquipmentInfoCode());
        int result = service.addEquipmentInfo(equipmentInfo);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改
     * @param equipmentInfo
     * @return
     */
    @RequestMapping("/updateEquipment")
    public boolean updateEquipmentInfo(@RequestBody EquipmentInfo equipmentInfo) {
        System.out.println(equipmentInfo);
        int result = service.updateEquipmentInfo(equipmentInfo);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteEquipment/{id}")
    public boolean deleteEquipmentInfo(@PathVariable("id")String id) {
        int result = service.deleteEquipmentInfo(id);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 找出所有可以租借的设备
     * @param pageCode
     * @param pageSize
     * @return
     */
    @RequestMapping("/eqipmentsRentable/{pageCode}/{pageSize}")
    public PageInfo<EquipmentInfo> getAllEquipmentInfoRentable(@PathVariable int pageCode, @PathVariable  int pageSize) {
        PageHelper.startPage(pageCode,pageSize,true);
        List<EquipmentInfo> equipmentInfos = service.queryAllEquipmentInfoRenable();
        return new PageInfo<>(equipmentInfos);
    }

    /**
     * 租借设备
     * @param equipmentInfo
     * @return
     */
    @RequestMapping("/rentEquipment")
    public boolean rentOrback(@RequestBody EquipmentInfo equipmentInfo) {
        int result = service.rentOrback(equipmentInfo);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 返回前端排产的级联菜单
     * @param userId
     * @return
     */
    @RequestMapping("/scheduling/{userId}")
    public List<EquipCate_Info> queryMenu(@PathVariable String userId) {
        Factory factory = factoryService.queryFactoryByUserId(userId);
        String factoryid = factory.getId();
        List<EquipmentCategory> equipmentCategories = categoryService.queryAllEquipmentCategories();
        List<EquipmentInfo> equipmentInfos = service.queryAllEquipmentInfosByUserId(factoryid);
        List<EquipCate_Info> list = new ArrayList<>();
        for(EquipmentCategory category : equipmentCategories) {
            EquipCate_Info item = new EquipCate_Info();
            item.setId(category.getId());
            item.setName(category.getName());
            List<EquipmentMenuPojo> sub = new ArrayList<>();
            for(EquipmentInfo equipmentInfo : equipmentInfos) {
                if (2==equipmentInfo.getStatus()) //只有空闲状态的设备才可以排产
                {
                    if (equipmentInfo.getEquipmentcate_id().equals(category.getId())) {
                        EquipmentMenuPojo item1 = new EquipmentMenuPojo();
                        item1.setId(equipmentInfo.getId());
                        item1.setName(equipmentInfo.getEquip_code());
                        sub.add(item1);
                    }
                }
            }
            item.setEquipmentMenuPojos(sub);
            list.add(item);
        }
        return list;
    }

    /**
     * 获取设备总数
     * @return
     */
    @RequestMapping("/getEquipCounts")
    public int getCounts(){
        return service.getCounts();
    }
}

