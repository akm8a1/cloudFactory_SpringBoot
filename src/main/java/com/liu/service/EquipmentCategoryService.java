package com.liu.service;

import com.liu.pojo.EquipmentCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 设备类别Service接口
 */
public interface EquipmentCategoryService {
    /**
     * 获取所有的设别类别
     * @return
     */
    List<EquipmentCategory> queryAllEquipmentCategories();

    /**
     * 根据类型名字查找设备类型
     * @param likename
     * @return
     */
    List<EquipmentCategory> queryEquipmentCategoryByName(@Param("likename")String likename);

    /**
     * 增加一个设备类型
     * @param equipmentCategory
     * @return
     */
    int addEquipmentCategory(EquipmentCategory equipmentCategory);

    /**
     * 修改一个设备类别
     * @param equipmentCategory
     * @return
     */
    int updateEquipmentCategory(EquipmentCategory equipmentCategory);

    /**
     * @param id
     * @return
     */
    /*删除一个设备类别*/
    int deleteEquipmentCategory(@Param("id") String id);

    /**
     * 总数
     * @return
     */
    int getCounts();

    /**
     * 查找在这个cate下设备的数量
     * @param id
     * @return
     */
    int getEquipmentCounts(String id);

    /**
     * 查找这个cate下对应factory的设备数
     * @param id
     * @param factoryid
     * @return
     */
    int getEquipmentFactoryCounts(String id,String factoryid);
}
