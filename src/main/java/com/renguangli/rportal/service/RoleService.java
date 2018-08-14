package com.renguangli.rportal.service;

import com.renguangli.rportal.pojo.Role;

import java.util.List;

/**
 * RoleService
 *
 * @author renguangli 2018/8/2 14:32
 * @since JDK 1.8
 */
public interface RoleService {

    List<Role> listRole(Role role, int page, int limit);

    int countRole(Role role);

    boolean saveRole(Role role);

    boolean deleteRole(Integer roleId);

    boolean batchDeleteRole(Integer[] roleIds);

    boolean updateRole(Role role);
}
