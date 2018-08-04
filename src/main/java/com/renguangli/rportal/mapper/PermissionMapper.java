package com.renguangli.rportal.mapper;

import com.renguangli.rportal.bean.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserMapper
 *
 * @author renguangli 2018/8/2 14:34
 * @since JDK 1.8
 */
public interface PermissionMapper {

    List<Permission> listPermission(@Param("permission") Permission permission);

    boolean save(@Param("permission") Permission permission);

    boolean deletePermission(@Param("permission") Permission permission);
}
