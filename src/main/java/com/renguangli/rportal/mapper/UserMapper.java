package com.renguangli.rportal.mapper;

import com.renguangli.rportal.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * UserMapper
 *
 * @author renguangli 2018/8/2 14:34
 * @since JDK 1.8
 */
public interface UserMapper {

    String login(@Param("username") String username);
}
