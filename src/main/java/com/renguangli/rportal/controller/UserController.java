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
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/users")
    public Result listUser(User user, int page, int limit) {
        List<User> data = userService.listUser(user, page, limit);
        int count = userService.countUser(user);
        return new Result(data, count);
    }

    @PostMapping("/user")
    public boolean saveUser(User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/user/{userId}")
    public boolean deleteUser(@PathVariable("userId") Integer userId) {
        return userService.deleteUser(userId);
    }

    @DeleteMapping("/users")
    public boolean batchDeleteUser(@RequestParam("userIds[]") Integer[] userIds) {
        return userService.batchDeleteUser(userIds);
    }

    @PutMapping("/user")
    public boolean updateUser(User user) {
        return userService.updateUser(user);
    }

}
