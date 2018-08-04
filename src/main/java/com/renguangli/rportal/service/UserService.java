package com.renguangli.rportal.service;

import com.renguangli.rportal.bean.User;

import java.util.Set;

/**
 * UserService
 *
 * @author renguangli 2018/8/2 14:32
 * @since JDK 1.8
 */
public interface UserService {

    User getUser(User user);

    Set<String> listRole(String username);

    Set<String> listUrl(String username);

}
