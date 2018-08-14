package com.renguangli.rportal.mapper;

import com.renguangli.rportal.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * RoleMapper
 *
 * @author renguangli 2018/8/2 14:34
 * @since JDK 1.8
 */
public interface RoleMapper extends BaseMapper<Role, Integer> {

    List<Role> listRole(@Param("pojo") Role role, @Param("page") int page,  @Param("limit") int limit);

    int countRole(@Param("pojo") Role role);
}
