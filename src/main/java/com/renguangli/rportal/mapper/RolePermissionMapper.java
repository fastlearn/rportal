package com.renguangli.rportal.mapper;

import com.renguangli.rportal.pojo.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * RoleMapper
 *
 * @author renguangli 2018/8/2 14:34
 * @since JDK 1.8
 */
public interface RolePermissionMapper extends BaseMapper<RolePermission, Integer> {

    List<RolePermission> listByRoleId(@Param("roleId") Integer roleId);

    boolean deleteByRoleId(@Param("roleId") Integer roleId);

    /**
     * 数组roleIds元素要大于0
     */
    boolean batchDeleteByRoleIds(@Param("roleIds") Integer[] roleIds);

}
