package com.liu.service;

import com.liu.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色Service接口
 */
public interface RoleService {
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
}
