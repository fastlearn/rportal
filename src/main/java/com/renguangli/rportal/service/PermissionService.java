package com.renguangli.rportal.service;

import com.renguangli.rportal.bean.Permission;

import java.util.List;

/**
 * PermissionService
 *
 * @author renguangli 2018/8/2 13:34
 * @since JDK 1.8
 */
public interface PermissionService {

    List<Permission> listPermission();

    List<Permission> listPermission(Permission permission, Integer page, Integer limit);

    int countPermission(Permission permission);

    boolean savePermission(Permission permission);

    boolean deletePermission(Permission permission);


}
