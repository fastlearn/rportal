package com.renguangli.rportal.service.impl;

import com.renguangli.rportal.mapper.PermissionMapper;
import com.renguangli.rportal.pojo.Permission;
import com.renguangli.rportal.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
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
    public List<Permission> listPermission() {
        return permissionMapper.list();
    }

    @Override
    public List<Permission> listPermissionByFixed(boolean fixed) {
        return permissionMapper.listPermissionByFixed(fixed);
    }

    @Override
    public List<Permission> listPermission(Permission permission, Integer page, Integer limit) {
        page = (page -1) * limit;
        return permissionMapper.listPermission(permission, page, limit);
    }

    @Override
    public int countPermission(Permission permission) {
        return permissionMapper.countPermission(permission);
    }

    @Override
    public boolean savePermission(Permission permission) {
        return permissionMapper.save(permission);
    }

    @Override
    public boolean deletePermission(Integer permissionId) {
        return permissionMapper.delete(permissionId);
    }

    @Override
    public boolean batchDeletePermission(Integer[] permissionIds) {
        return permissionMapper.batchDelete(permissionIds);
    }

}
