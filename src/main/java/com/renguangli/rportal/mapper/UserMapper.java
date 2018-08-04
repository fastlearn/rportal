package com.renguangli.rportal.mapper;

import com.renguangli.rportal.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * UserMapper
 *
 * @author renguangli 2018/8/2 14:34
 * @since JDK 1.8
 */
public interface UserMapper {

    User getUser(@Param("user")User user);

    Set<String> listRole(@Param("username") String username);

    Set<String> listUrl(@Param("username") String username);
}
