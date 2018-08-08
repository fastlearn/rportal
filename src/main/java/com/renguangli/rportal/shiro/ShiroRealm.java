package com.renguangli.rportal.shiro;

import com.renguangli.rportal.bean.User;
import com.renguangli.rportal.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * ShiroRealm
 *
 * @author renguangli 2018/8/2 13:29
 * @since JDK 1.8
 */
@Service("shiroRealm")
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.listRole(username));
        authorizationInfo.setStringPermissions(userService.listUrl(username));
        userService.listRole(username).forEach(System.out::println);
        System.out.println();
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        User user = new User(username);
        user = userService.getUser(user);
        if (user == null) { // 用户不存在
            throw new UnknownAccountException();
        }
        if (User.LOCKED.equals(user.getLocked())) {// 账号锁定
            throw new LockedAccountException();
        }
        long days = ChronoUnit.DAYS.between(user.getPasswordUpdateDatetime(), LocalDateTime.now());
        if (user.getExpired() < days) { // 密码过期
            throw new ExpiredCredentialsException();
        }
        String password = user.getPassword();
        //构造一个用户认证信息并返回，后面会通过这个和token的pwd进行对比。
        return new SimpleAuthenticationInfo(username,password,this.getName());
    }

}
