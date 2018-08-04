package com.renguangli.rportal.service.impl;

import com.renguangli.rportal.bean.Permission;
import com.renguangli.rportal.mapper.PermissionMapper;
import com.renguangli.rportal.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * PermissionServiceImpl
 *
 * @author renguangli 2018/8/2 13:34
 * @since JDK 1.8
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    private final PermissionMapper permissionMapper;

    @Autowired
    public PermissionServiceImpl(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public List<Permission> listPermission(Permission permission) {
        return permissionMapper.listPermission(permission);
    }

    @Override
    public boolean savePermission(Permission permission) {
        return permissionMapper.save(permission);
    }

    @Override
    public boolean deletePermission(Permission permission) {
        return permissionMapper.deletePermission(permission);
    }

}
