package com.renguangli.rportal.controller;

import com.alibaba.fastjson.JSON;
import com.renguangli.rportal.bean.Permission;
import com.renguangli.rportal.service.PermissionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
    public String permissionList(Permission permission) {
        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("count", 5);
        data.put("msg", "草泥马");
        data.put("data",permissionService.listPermission(permission));
        return JSON.toJSONString(data);
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
