package com.renguangli.rportal.controller;

import com.renguangli.rportal.pojo.Result;
import com.renguangli.rportal.pojo.Role;
import com.renguangli.rportal.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    public Result listRole(Role role, int page, int limit) {
        List<Role> roles = roleService.listRole(role, page, limit);
        int count = roleService.countRole(role);
        return new Result(roles, count);
    }

    @PostMapping("/save")
    public Result saveRole(Role role) {
        System.out.println(role);
        boolean flag = roleService.saveRole(role);
        return new Result(0, flag);
    }

    @PostMapping("/delete")
    public Result deleteRole(Integer roleId) {
        boolean flag = roleService.deleteRole(roleId);
        return new Result(0, flag);
    }

    @PostMapping("/batchDelete")
    public Result batchDeleteRole(@RequestParam("roleIds[]") Integer[] roleIds) {
        boolean flag = roleService.batchDeleteRole(roleIds);
        return new Result(0, flag);
    }

    @PostMapping("/update")
    public Result updateRole(Role role) {
        boolean flag = roleService.updateRole(role);
        return new Result(0, flag);
    }

}
