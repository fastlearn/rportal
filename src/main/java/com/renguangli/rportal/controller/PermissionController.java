package com.renguangli.rportal.controller;

import com.renguangli.rportal.bean.Permission;
import com.renguangli.rportal.bean.Result;
import com.renguangli.rportal.service.PermissionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * PermissionController
 *
 * @author renguangli 2018/8/2 13:25
 * @since JDK 1.8
 */
@RestController
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    @GetMapping("/permissions")
    public Result permissionList(Permission permission, Integer page, Integer limit) {
        List<Permission> data = permissionService.listPermission(permission, page, limit);
        int count = permissionService.countPermission(permission);
        return new Result(data, count);
    }

    @PostMapping("/permission")
    public boolean savePermission(Permission permission) {
        return permissionService.savePermission(permission);
    }

    @DeleteMapping("/permission")
    public boolean deletePermission(Permission permission) {
        return permissionService.deletePermission(permission);
    }
}
