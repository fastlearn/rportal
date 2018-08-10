package com.renguangli.rportal.controller;

import com.renguangli.rportal.pojo.User;
import com.renguangli.rportal.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
    public Map<String, Object> listUser(User user, int page, int limit) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("count", 5);
        result.put("msg", "获取用户信息成功");
        result.put("data", userService.listUser(user, page, limit));
        int count = userService.countUser(user);
        return result;
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
    public boolean batchDeleteUser(@PathVariable("userIds[]") Integer[] userIds) {
        return userService.batchDeleteUser(userIds);
    }

    @PutMapping("/user")
    public boolean updateUser(User user) {
        return userService.updateUser(user);
    }

}
