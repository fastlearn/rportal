package com.renguangli.rportal.service;

import com.renguangli.rportal.bean.User;

import java.util.List;
import java.util.Set;

/**
 * UserService
 *
 * @author renguangli 2018/8/2 14:32
 * @since JDK 1.8
 */
public interface UserService {

    User getUser(User user);

    List<User> listUser(User user);

    Set<String> listRole(String username);

    Set<String> listUrl(String username);

    boolean saveUser(User user);

    boolean deleteUser(User user);

    boolean updateUser(User user);
}
