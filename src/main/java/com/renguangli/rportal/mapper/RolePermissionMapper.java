package com.renguangli.rportal.mapper;

import com.renguangli.rportal.pojo.RolePermission;
import org.apache.ibatis.annotations.Param;

/**
 * RoleMapper
 *
 * @author renguangli 2018/8/2 14:34
 * @since JDK 1.8
 */
public interface RolePermissionMapper extends BaseMapper<RolePermission, Integer> {

    boolean deleteByRoleId(@Param("roleId") Integer roleId);

}
