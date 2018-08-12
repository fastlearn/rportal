package com.renguangli.rportal.shiro;

import com.renguangli.rportal.service.ShiroService;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * ShiroConfiguration
 *
 * @author renguangli 2018/8/2 13:18
 * @since JDK 1.8
 */
@Configuration
public class ShiroConfiguration {

    @Resource
    private ShiroRealm shiroRealm;

    @Resource
    private ShiroService shiroService;

    @Bean
    public SimpleCookie simpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(604800); //七天
        return simpleCookie;
    }

    @Bean
    public RememberMeManager rememberMeManager() {
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCookie(simpleCookie());
        rememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return rememberMeManager;
    }

    /**
     * 配置securityManager
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    /**
     * 配置FilterFactoryBean
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager()); // 设置 SecurityManager
        shiroFilterFactoryBean.setLoginUrl("/login"); //设置登录链接,默认 /login.jsp
        shiroFilterFactoryBean.setSuccessUrl("/"); // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setUnauthorizedUrl("/403"); // 未授权跳转链接;

        // 添加自定义过滤器
        Map<String, Filter> filters = new HashMap<>();
        filters.put("authc", new CustomFormAuthenticationFilter());
        filters.put("validateCode", new ValidateCodeFilter());
        filters.put("perms", new CustomPermissionsAuthorizationFilter());
        shiroFilterFactoryBean.setFilters(filters);

        // 从数据库中读取拦截链配置
        /*Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/login", "validateCode,authc");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/validateCode", "anon");
        filterChainDefinitionMap.put("/layui/**", "anon");
        filterChainDefinitionMap.put("/lib/**", "anon");
        filterChainDefinitionMap.put("/images/**", "anon");
        filterChainDefinitionMap.put("/pageView/user", "perms[user:manager]");
        filterChainDefinitionMap.put("/test/**", "user");
        filterChainDefinitionMap.put("/**", "authc");*/
        Map<String, String> filterChainDefinitionMap = shiroService.getFilterChainDefinitionMap();
        filterChainDefinitionMap.put("/users", "rest[user]");
        filterChainDefinitionMap.forEach((key, value) -> {
            System.out.println(key + "=" + value);
        });
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

}
