package com.renguangli.rportal.service;

import java.util.Set;

/**
 * RoleService
 *
 * @author renguangli 2018/8/2 14:32
 * @since JDK 1.8
 */
public interface RoleService {

    Set<String> listRoles(String username);
}
