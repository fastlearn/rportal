package com.renguangli.rportal.service.impl;

import com.renguangli.rportal.mapper.RoleMapper;
import com.renguangli.rportal.pojo.Role;
import com.renguangli.rportal.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * RoleServiceImpl
 *
 * @author renguangli 2018/8/2 14:32
 * @since JDK 1.8
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public Set<String> listRoles(Role role) {
        return roleMapper.listRoles(role);
    }

    @Override
    @Transactional
    public boolean saveRole(Role role) {
        return roleMapper.save(role);
    }

    @Override
    @Transactional
    public boolean deleteRole(Integer roleId) {
        return roleMapper.delete(roleId);
    }

    @Override
    @Transactional
    public boolean batchDeleteRole(Integer[] roleIds) {
        return roleMapper.batchDelete(roleIds);
    }

    @Override
    @Transactional
    public boolean updateRole(Role role) {
        return roleMapper.update(role);
    }
}
