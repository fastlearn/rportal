package com.renguangli.rportal.controller;

import com.renguangli.rportal.pojo.Result;
import com.renguangli.rportal.pojo.User;
import com.renguangli.rportal.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserController
 *
 * @author renguangli 2018/8/2 13:25
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/list")
    public Result listUser(User user, int page, int limit) {
        List<User> data = userService.listUser(user, page, limit);
        int count = userService.countUser(user);
        return new Result(data, count);
    }

    @PostMapping("/save")
    public Result saveUser(User user) {
        boolean flag = userService.saveUser(user);
        return new Result(0, flag);
    }

    @PostMapping("/delete")
    public Result deleteUser(Integer userId) {
        boolean flag = userService.deleteUser(userId);
        return new Result(0, flag);
    }

    @PostMapping("/batchDelete")
    public Result batchDeleteUser(@RequestParam("userIds[]") Integer[] userIds) {
        boolean flag = userService.batchDeleteUser(userIds);
        return new Result(0, flag);
    }

    @PostMapping("/update")
    public Result updateUser(User user) {
        boolean flag = userService.updateUser(user);
        return new Result(0, flag);
    }

}
