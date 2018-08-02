package com.renguangli.rportal.shiro;

import com.renguangli.rportal.bean.Permission;
import com.renguangli.rportal.service.PermissionService;
import com.renguangli.rportal.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
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
    private PermissionService permissionService;

    @Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        String password = userService.login(username);
        if (password == null) { //用户不存在
            throw new UnknownAccountException();
        }
        //构造一个用户认证信息并返回，后面会通过这个和token的pwd进行对比。
        return new SimpleAuthenticationInfo(username,password,this.getName());

    }

    /**
     * 构造shiro过滤链配置
     */
    protected Map<String,String> doGetFilterChainDefinitionMap(){
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 从数据库获取url权限配置
        List<Permission> permissions = permissionService.listPermission();
       /* for (Permission permission : permissions) {
            filterChainDefinitionMap.put("url","roles");
        }*/
        //配置静态资源不拦截
        filterChainDefinitionMap.put("/static/**", "anon");
        //配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/**", "authc");
        return filterChainDefinitionMap;
    }
}
