package com.liu.mapper;

import com.liu.pojo.Factory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 云工厂Mapper
 */
@Mapper//表示是一个MyBatis接口
@Repository
public interface FactoryMapper {
    /**
     * 获取所有的工厂
     * @return
     */
    List<Factory> queryFactorys();

    /**
     * 增加一个Factory
     * @param factory
     * @return
     */

    int addFactory(Factory factory);

    /**
     * 删除一个Factory
     * @param id
     * @return
     */

    int deleteFactory(@Param("id") String id);

    /**
     * 修改工厂信息
     * @param factory
     * @return
     */

    int updateFactory(Factory factory);

    /**
     * 根据工厂的名字模糊查询
     * @param likename
     * @return
     */

    List<Factory> queryFactoryByLikeName(@Param("likename") String likename);

    /**
     * 根据id查询Facotry
     * @param id
     * @return
     */

    Factory queryFactoryById(@Param("id") String id);

    /**
     * 根据userid查询Factory
     * @param id
     * @return
     */

    Factory queryFactoryByUserId(@Param("id") String id);

    /**
     * 根据orderid查询对应的factory
     * @param id
     * @return
     */

    Factory queryFactoryByOrderId(@Param("orderid") String id);
}
