package com.renguangli.rportal.service;

import com.renguangli.rportal.pojo.RolePermission;

import java.util.List;

public interface RolePermissionService {

    List<RolePermission> listByRoleId(Integer roleId);

    /**
     * 集合rolePermissions元素要大于 0
     */
    boolean batchSave(List<RolePermission> rolePermissions);

    boolean deleteByRoleId(Integer roleId);

    /**
     * 数据roleIds元素要大于 0
     */
    boolean batchDeleteByRoleIds(Integer[] roleIds);
}
