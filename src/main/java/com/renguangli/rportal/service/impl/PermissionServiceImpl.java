package com.renguangli.rportal.service.impl;

import com.renguangli.rportal.bean.Permission;
import com.renguangli.rportal.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * PermissionServiceImpl
 *
 * @author renguangli 2018/8/2 13:34
 * @since JDK 1.8
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    /**
     * 获取所有permission
     * @return List<Permission>
     */
    @Override
    public List<Permission> listPermission() {
        return new ArrayList<>();
    }

}
