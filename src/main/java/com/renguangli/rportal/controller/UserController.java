package com.renguangli.rportal.controller;

import com.renguangli.rportal.bean.User;
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
    public List<User> listUser(User user) {
        return userService.listUser(user);
    }

    @PostMapping("/user")
    public boolean saveUser(User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/user/{userId}")
    public boolean deleteUser(@PathVariable("userId") Integer userId) {
        return userService.deleteUser(new User(userId));
    }

    @PutMapping("/user")
    public boolean updateUser(User user) {
        return userService.updateUser(user);
    }
}
