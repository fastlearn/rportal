package com.renguangli.rportal.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {

        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else if (LockedAccountException.class.getName().equals(exception)) {
                System.out.println("LockedAccountException -- > 账号锁定");
                msg = "LockedAccountException -- > 账号锁定";
            }else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        request.setAttribute("msg", msg);
        return "login";
    }

/*    public String login(User user, Model model) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            subject.login(token);
            return "redirect:/";
        } catch (UnknownAccountException e) {
            log.warn("用户认证失败,用户名[{}]不存在！", user.getUsername());
            model.addAttribute("msg", "用户名不存在");
        } catch (IncorrectCredentialsException e) {
            log.warn("用户[{}]认证失败,密码[{}]正确！", user.getUsername(), user.getPassword());
            model.addAttribute("msg", "不正确的密码");
        } catch (LockedAccountException e) {
            log.warn("用户认证失败,账号[{}]已锁定！", user.getUsername());
            model.addAttribute("msg", "账号已锁定！");
        } catch (ExpiredCredentialsException e) {
            // todo 密码过期进入修改密码页面
        }
        return "login";
    }*/

}
