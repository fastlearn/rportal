package com.renguangli.rportal.service.impl;

import com.renguangli.rportal.mapper.RoleMapper;
import com.renguangli.rportal.mapper.UserMapper;
import com.renguangli.rportal.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * RoleServiceImpl
 *
 * @author renguangli 2018/8/2 14:32
 * @since JDK 1.8
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public Set<String> listRoles(String username) {
        return roleMapper.listRoles(username);
    }
}
