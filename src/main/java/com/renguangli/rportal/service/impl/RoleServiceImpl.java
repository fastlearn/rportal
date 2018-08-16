package com.renguangli.rportal.service.impl;

import com.renguangli.rportal.mapper.RoleMapper;
import com.renguangli.rportal.mapper.RolePermissionMapper;
import com.renguangli.rportal.pojo.Role;
import com.renguangli.rportal.service.RolePermissionService;
import com.renguangli.rportal.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * RoleServiceImpl
 *
 * @author renguangli 2018/8/2 14:32
 * @since JDK 1.8
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    private final RolePermissionMapper rolePermissionMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper, RolePermissionMapper rolePermissionMapper) {
        this.roleMapper = roleMapper;
        this.rolePermissionMapper = rolePermissionMapper;
    }

    @Override
    public List<Role> listRole(Role role, int page, int limit){
        page = (page - 1) * limit;
        return roleMapper.listRole(role, page, limit);
    }

    @Override
    public int countRole(Role role) {
        return roleMapper.countRole(role);
    }

    @Override
    @Transactional
    public boolean saveRole(Role role) {
        role.setCreateDatetime(LocalDateTime.now());
        return roleMapper.save(role);
    }

    @Override
    @Transactional
    public boolean deleteRole(Integer roleId) {
        boolean flag = roleMapper.delete(roleId);
        if (flag) {
            rolePermissionMapper.deleteByRoleId(roleId);
        }
        return flag;
    }

    @Override
    @Transactional
    public boolean batchDeleteRole(Integer[] roleIds) {
        boolean flag = roleMapper.batchDelete(roleIds);
        if (flag) {
            rolePermissionMapper.batchDeleteByRoleIds(roleIds);
        }
        return flag;
    }

    @Override
    @Transactional
    public boolean updateRole(Role role) {
        return roleMapper.update(role);
    }
}
