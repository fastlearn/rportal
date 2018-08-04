package com.renguangli.rportal.shiro;

import com.renguangli.rportal.bean.Permission;
import com.renguangli.rportal.bean.User;
import com.renguangli.rportal.service.PermissionService;
import com.renguangli.rportal.service.ShiroService;
import com.renguangli.rportal.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        User user = new User(username);
        user = userService.getUser(user);
        String password = user.getPassword();
        if (user.getUsername() == null) { //用户不存在
            throw new UnknownAccountException();
        }
        //构造一个用户认证信息并返回，后面会通过这个和token的pwd进行对比。
        return new SimpleAuthenticationInfo(username,password,this.getName());
    }

}
