package com.renguangli.rportal.controller;

import com.renguangli.rportal.pojo.Result;
import com.renguangli.rportal.pojo.Role;
import com.renguangli.rportal.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * RoleController
 *
 * @author renguangli 2018/8/2 13:25
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @GetMapping("/list")
    public Result listRole() {
        return new Result();
    }

    @GetMapping("/save")
    public Result saveRole(Role role) {
        boolean flag = roleService.saveRole(role);
        return new Result();
    }

    @GetMapping("/delete")
    public Result deleteRole(Integer roleId) {
        boolean flag = roleService.deleteRole(roleId);
        return new Result();
    }

    @GetMapping("/batchDelete")
    public Result batchDeleteRole(@RequestParam("roleIds[]") Integer[] roleIds) {
        boolean flag = roleService.batchDeleteRole(roleIds);
        return new Result();
    }

    @GetMapping("/update")
    public Result updateRole(Role role) {
        boolean flag = roleService.updateRole(role);
        return new Result();
    }

}
