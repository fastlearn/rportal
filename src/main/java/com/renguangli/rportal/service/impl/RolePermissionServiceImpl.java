package com.renguangli.rportal.service.impl;

import com.renguangli.rportal.mapper.RolePermissionMapper;
import com.renguangli.rportal.pojo.RolePermission;
import com.renguangli.rportal.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionMapper rolePermissionMapper;

    @Autowired
    public RolePermissionServiceImpl(RolePermissionMapper rolePermissionMapper) {
        this.rolePermissionMapper = rolePermissionMapper;
    }

    @Override
    public List<RolePermission> listByRoleId(Integer roleId) {
        return rolePermissionMapper.listByRoleId(roleId);
    }

    @Override
    @Transactional
    public boolean batchSave(List<RolePermission> rolePermissions) {
        Integer roleId = rolePermissions.get(0).getRoleId();
        rolePermissionMapper.deleteByRoleId(roleId);
        return rolePermissionMapper.batchSave(rolePermissions);
    }

    @Override
    public boolean deleteByRoleId(Integer roleId) {
        return rolePermissionMapper.deleteByRoleId(roleId);
    }

    @Override
    public boolean batchDeleteByRoleIds(Integer[] roleIds) {
        return rolePermissionMapper.batchDeleteByRoleIds(roleIds);
    }
}
