package com.renguangli.rportal.service;

import com.renguangli.rportal.pojo.RolePermission;

import java.util.List;

public interface RolePermissionService {

    boolean batchSave(List<RolePermission> rolePermissions);
}
