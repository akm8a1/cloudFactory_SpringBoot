package com.liu.mapper;

import com.liu.pojo.Ability;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产能配置mapper
 */
@Mapper
@Repository
public interface AbilityMapper {
    /**
     * @return 查找所有的产能数据
     */
    List<Ability> queryAllAbilities();

    /**
     * 增加一条数据
     * @param ability
     * @return
     */
    int addAbility(Ability ability);

    /**
     * 删除一条数据
     * @param id
     * @return
     */
    int deleteAbility(@Param("id") String id);

    /**
     * 修改一条数据
     * @param ability
     * @return
     */
    int updateAbility(Ability ability);
}
