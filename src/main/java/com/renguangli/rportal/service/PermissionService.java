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

    /**
     * 获取所有permission
     * @return List<Permission>
     */
    List<Permission> listPermission();

}
