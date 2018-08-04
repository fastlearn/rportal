package com.renguangli.rportal.controller;

import com.renguangli.rportal.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, Model model) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            subject.login(token);
            return "redirect:/";
        } catch (UnknownAccountException e) {
            log.warn("登陆失败,用户名[{}]不存在！", user.getUsername());
            model.addAttribute("msg", "用户名不存在");
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }
}
