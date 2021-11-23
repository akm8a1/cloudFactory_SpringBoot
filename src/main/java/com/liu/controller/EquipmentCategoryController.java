package com.liu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.pojo.EquipmentCategory;
import com.liu.pojo.EquipmentInfo;
import com.liu.pojo.User;
import com.liu.service.EquipmentCategoryService;
import com.liu.utils.Utils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 陆源东
 * 设备类别管理Controller
 */
@RestController
public class EquipmentCategoryController {
    @Autowired
    private EquipmentCategoryService service;

    /**
     * 分页查询设备类别
     * @param pageCode
     * @param pageSize
     * @return
     */
    @GetMapping("/equipmentCategory/{pageCode}/{pageSize}")
    public PageInfo<EquipmentCategory> queryEquipmentCategories(@PathVariable int pageCode, @PathVariable  int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize,true);
        //调用分页查询方法，mybaits自动进行分页的计算
        List<EquipmentCategory> categories = service.queryAllEquipmentCategories();
        return new PageInfo<>(categories);
    }

    /**
     * 查询所有设备类别
     * @return
     */
    @GetMapping("/equipmentCategory")
    public List<EquipmentCategory> queryEquipmentCategories() {
        List<EquipmentCategory> categories = service.queryAllEquipmentCategories();
        return categories;
    }

    /**
     * 模糊查询
     * @param catename
     * @return
     */
    @GetMapping("/searchEquipmentCate/{catename}")
    public List<EquipmentCategory> queryEquipmentCategoryByLikeName(@PathVariable("catename")String catename) {
        return service.queryEquipmentCategoryByName(catename);
    }

    /**
     * 新增设备类别
     * @param equipmentCategory
     * @return
     */
    @PostMapping("/addEquipmentCategory")
    public boolean addEquipmentCategory(@RequestBody EquipmentCategory equipmentCategory){
        equipmentCategory.setId(Utils.getUUID());
        int result = service.addEquipmentCategory(equipmentCategory);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除设备类别
     * @param id
     * @return
     */
    @RequestMapping("/deleteEquipmentCategory/{id}")
    public boolean deleteEquipmentCategory(@PathVariable("id") String id){
        int result = service.deleteEquipmentCategory(id);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改设备类别
     * @param equipmentCategory
     * @return
     */
    @PostMapping("/updateEquipmentCategory")
    public boolean updateEquipmentCategory(@RequestBody EquipmentCategory equipmentCategory){
        int result = service.updateEquipmentCategory(equipmentCategory);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取设备类别总数
     * @return
     */
    @RequestMapping("/getEquipCateCounts")
    public int getCounts(){
        return service.getCounts();
    }

    /**
     * 获取某类别下设备的数量
     * @param id
     * @return
     */
    @RequestMapping("/equipCountsInCate/{id}")
    public boolean getequipCountsInCate(@PathVariable("id")String id) {
        System.out.println(id);
        int result = service.getEquipmentCounts(id);
        System.out.println(result);
        if (result>0) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * 获取某类别下factory的设备的数量
     * @param id
     * @param factoryid
     * @return
     */
    @RequestMapping("/equipFactoryCountsInCate/{id}/{factoryid}")
    public boolean getequipCountsInCate(@PathVariable("id")String id,@PathVariable("factoryid")String factoryid) {
        int result = service.getEquipmentFactoryCounts(id,factoryid);
        if (result>0) {
            return false;
        } else {
            return true;
        }
    }
}
