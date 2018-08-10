package com.renguangli.rportal.controller;

import com.renguangli.rportal.shiro.ValidateCodeException;
import com.renguangli.rportal.util.CreateImageCode;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * LoginController
 *
 * @author renguangli 2018/8/2 13:25
 * @since JDK 1.8
 */
@Controller
public class LoginController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/login")
    public String login(HttpServletRequest request, String username, String password) {
        //shiro将认证异常信息封装到request中、、FormAuthenticationFilter:setFailureAttribute
        String exception = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        if (exception == null) {
            return "login";
        }
        String msg = "";
        if (UnknownAccountException.class.getName().equals(exception)) {
            log.warn("用户认证失败,用户名[{}]不存在！", username);
            msg = "用户不存在";
        } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
            log.warn("用户[{}]认证失败,密码[{}]不正确！", username, password);
            msg = "密码不正确";
        } else if (LockedAccountException.class.getName().equals(exception)) {
            log.warn("用户认证失败,账号[{}]已锁定！", username);
            msg = "账号已锁定";
        } else if (ExpiredCredentialsException.class.getName().equals(exception)) {
            log.warn("账号[{}]密码[{}]已过期！", username, password);
            // todo 密码过期进入修改密码页面
        } else if (ValidateCodeException.class.getName().equals(exception)) {
            log.warn("验证码错误！");
            msg = "验证码错误！";
        } else {
            log.warn("用户[{}]认证失败！", username);
            msg = "用户认证失败";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        return "login";
    }

    @GetMapping("/validateCode")
    public void validateCode(HttpServletResponse response, HttpSession session) throws IOException {
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        CreateImageCode validateCode = new CreateImageCode(100,37,4,10);
        //将验证码放入session
        session.setAttribute("validateCode", validateCode.getCode());
        validateCode.write(response.getOutputStream());
    }

}
