package com.renguangli.rportal.mapper;

import com.renguangli.rportal.pojo.Role;

import java.util.Set;

/**
 * RoleMapper
 *
 * @author renguangli 2018/8/2 14:34
 * @since JDK 1.8
 */
public interface RoleMapper extends BaseMapper<Role, Integer> {

    Set<String> listRoles(Role role);

}
