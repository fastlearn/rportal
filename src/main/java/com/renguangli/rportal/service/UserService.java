package com.renguangli.rportal.service;

import com.renguangli.rportal.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * UserService
 *
 * @author renguangli 2018/8/2 14:32
 * @since JDK 1.8
 */
public interface UserService {

    String login(String username);
}
