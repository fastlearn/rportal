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
    @Transactional
    public boolean batchSave(List<RolePermission> rolePermissions) {
        return rolePermissionMapper.deleteByRoleId(rolePermissions.get(0).getRoleId())
                && rolePermissionMapper.batchSave(rolePermissions);
    }
}
