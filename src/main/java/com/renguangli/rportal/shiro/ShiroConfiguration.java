package com.renguangli.rportal.shiro;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
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

    /**
     * 配置securityManager
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);
        return securityManager;
    }

    /**
     * 配置FilterFactoryBean
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager()); //设置 SecurityManager
        shiroFilterFactoryBean.setLoginUrl("/login"); //设置登录链接
        shiroFilterFactoryBean.setSuccessUrl("/"); // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setUnauthorizedUrl("/403"); // 未授权跳转链接;
        // 拦截链配置
        Map<String, String> filterChainDefinitionMap = shiroRealm.doGetFilterChainDefinitionMap();
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


}
