package com.liu.mapper;

import com.liu.pojo.EquipmentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 设备Mapper
 */
@Mapper
@Repository
public interface EquipmentInfoMapper {
    /**
     * 查询所有的设备信息
     * @return
     */
    List<EquipmentInfo> queryAllEquipmentInfos();

    /**
     * @param no
     * @return
     */
    List<EquipmentInfo> queryEquipmentInByNo(@Param("no") String no);

    /**
     * @param equipmentInfo
     * @return
     */
    int addEquipmentInfo(EquipmentInfo equipmentInfo);

    /**
     * 修改设别
     * @param equipmentInfo
     * @return
     */

    int updateEquipmentInfo(EquipmentInfo equipmentInfo);

    /**
     * 删除设别
     * @param id
     * @return
     */

    int deleteEquipmentInfo(@Param("id") String id);

    /**
     * 根据工厂id查出所有的设备
     * @param id
     * @return
     */

    List<EquipmentInfo> queryAllEquipmentInfosByUserId(@Param("id") String id);

    /**
     * 找出所有的可租用设备
     * @return
     */

    List<EquipmentInfo> queryAllEquipmentInfoRenable();

    /**
     * 租用设备
     * @param equipmentInfo
     * @return
     */

    int rentOrback(EquipmentInfo equipmentInfo);

    /**
     * 修改设备状态
     * @param status
     * @param id
     * @return
     */

    int updateStatus(@Param("status")int status,@Param("id")String id);

    /**
     * 找到所有涉及某订单的设备
     * @param id
     * @return
     */

    List<EquipmentInfo> queryAllEquipsWithOrder(@Param("orderid")String id);

    /**
     * 总数
     * @return
     */

    int getCounts();
}
