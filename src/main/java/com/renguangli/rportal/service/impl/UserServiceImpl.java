package com.renguangli.rportal.service.impl;

import com.renguangli.rportal.mapper.ConfigMapper;
import com.renguangli.rportal.pojo.Config;
import com.renguangli.rportal.pojo.User;
import com.renguangli.rportal.mapper.UserMapper;
import com.renguangli.rportal.service.ConfigService;
import com.renguangli.rportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
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

    @Resource
    private ConfigService configService;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUser(User user) {
        return userMapper.getUser(user);
    }

    @Override
    public Set<String> listUrl(String username) {
        return userMapper.listUrl(username);
    }

    @Override
    public int countUser(User user) {
        return userMapper.countUser(user);
    }

    @Override
    @Transactional
    public boolean saveUser(User user) {
        //从配置表中获取密码过期时间
        String passwordExpired = configService.getConfig("passwordExpired");
        int expired = Integer.parseInt(passwordExpired);
        //设置密码过期时间
        user.setExpired(expired);
        return userMapper.save(user);
    }

    @Override
    @Transactional
    public boolean deleteUser(Integer userId) {
        return userMapper.delete(userId);
    }

    @Override
    @Transactional
    public boolean batchDeleteUser(Integer[] userIds) {
        return userMapper.batchDelete(userIds);
    }

    @Override
    @Transactional
    public boolean updateUser(User user) {
        return userMapper.update(user);
    }

    @Override
    public List<User> listUser(User user, int page, int limit) {
        page = (page - 1) * limit;
        return userMapper.listUser(user, page, limit);
    }

    @Override
    public Set<String> listRole(String username) {
        return userMapper.listRole(username);
    }

}
