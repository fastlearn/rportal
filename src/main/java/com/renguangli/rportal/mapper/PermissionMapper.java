package com.renguangli.rportal.mapper;

import com.renguangli.rportal.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserMapper
 *
 * @author renguangli 2018/8/2 14:34
 * @since JDK 1.8
 */
public interface PermissionMapper extends BaseMapper<Permission, Integer> {

    List<Permission> listPermission(@Param("pojo") Permission permission, @Param("page") Integer page, @Param("limit") Integer limit);

    int countPermission(@Param("pojo") Permission permission);

    boolean save(@Param("pojo") Permission permission);

}
