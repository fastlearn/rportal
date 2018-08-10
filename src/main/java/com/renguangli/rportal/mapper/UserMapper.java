package com.renguangli.rportal.mapper;

import com.renguangli.rportal.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * UserMapper
 *
 * @author renguangli 2018/8/2 14:34
 * @since JDK 1.8
 */
public interface UserMapper extends BaseMapper<User, Integer> {

    User getUser(@Param("pojo")User user);

    List<User> listUser(@Param("pojo") User user, @Param("page") int page, @Param("limit") int limit);

    int countUser(@Param("pojo") User user);

    Set<String> listRole(@Param("username") String username);

    Set<String> listUrl(@Param("username") String username);
}
