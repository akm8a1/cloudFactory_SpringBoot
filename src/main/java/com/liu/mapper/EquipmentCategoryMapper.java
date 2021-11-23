package com.liu.mapper;

import com.liu.pojo.EquipmentCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 设备类型Mapper
 */
@Mapper
@Repository
public interface EquipmentCategoryMapper {
    /**
     * 获取所有的设别类别
     * @return
     */
    /*获取所有的设别类别*/
    List<EquipmentCategory> queryAllEquipmentCategories();

    /**
     * 根据类型名字查找设备类型
     * @param likename
     * @return
     */
    /*根据类型名字查找设备类型*/
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
     * 删除一个设备类别
     * @param id
     * @return
     */

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

    int getEquipmentCounts(@Param("id") String id);

    /**
     * 查找这个cate下对应factory的设备数
     * @param id
     * @param factoryid
     * @return
     */

    int getEquipmentFactoryCounts(@Param("id") String id,@Param("factoryid")String factoryid);
}
