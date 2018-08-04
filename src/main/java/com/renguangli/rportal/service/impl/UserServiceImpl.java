package com.renguangli.rportal.service.impl;

import com.renguangli.rportal.bean.User;
import com.renguangli.rportal.mapper.UserMapper;
import com.renguangli.rportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * UserServiceImpl
 *
 * @author renguangli 2018/8/2 14:33
 * @since JDK 1.8
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUser(User user) {
        return userMapper.getUser(user);
    }

    @Override
    public Set<String> listRole(String username) {
        return userMapper.listRole(username);
    }

    @Override
    public Set<String> listUrl(String username) {
        return userMapper.listUrl(username);
    }


}
