package com.liu.service;

import com.liu.mapper.RoleMapper;
import com.liu.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色Service实现类
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper mapper;
    @Override
    public List<Role> queryAllRoles() {
        return mapper.queryAllRoles();
    }

    @Override
    public int addRole(Role role) {
        return mapper.addRole(role);
    }

    @Override
    public int updateRole(Role role) {
        return mapper.updateRole(role);
    }

    @Override
    public int deleteRole(String id) {
        return mapper.deleteRole(id);
    }
}
