package com.renguangli.rportal.mapper;

import java.util.Set;

/**
 * RoleMapper
 *
 * @author renguangli 2018/8/2 14:34
 * @since JDK 1.8
 */
public interface RoleMapper {

    Set<String> listRoles(String username);
}
