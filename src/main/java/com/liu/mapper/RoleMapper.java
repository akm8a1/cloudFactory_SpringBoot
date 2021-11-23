package com.liu.mapper;

import com.liu.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色Mapper
 */
@Mapper
@Repository
public interface RoleMapper {
    /**
     * 获取所有的数据
     * @return
     */

    List<Role> queryAllRoles();

    /**
     * 新增数据
     * @param role
     * @return
     */

    int addRole(Role role);

    /**
     * 修改数据
     * @param role
     * @return
     */

    int updateRole(Role role);

    /**
     * 删除数据
     * @param id
     * @return
     */

    int deleteRole(@Param("id") String id);

    /**
     * 总数
     * @return
     */

    int getCounts();
}
