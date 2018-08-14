package com.renguangli.rportal.controller;

import com.renguangli.rportal.pojo.Permission;
import com.renguangli.rportal.pojo.Result;
import com.renguangli.rportal.service.PermissionService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/permission/listAll")
    public Result permissionListAll(Permission permission, Integer page, Integer limit) {
        List<Permission> data = permissionService.listPermission();
        return new Result(0, data);
    }

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

    @DeleteMapping("/permission/{permissionId}")
    public boolean deletePermission(@PathVariable("permissionId")Integer permissionId) {
        return permissionService.deletePermission(permissionId);
    }

    @DeleteMapping("/permissions")
    public boolean batchDeletePermission(@RequestParam("permissionIds[]") Integer[] permissionIds) {
        return permissionService.batchDeletePermission(permissionIds);
    }
}
