package com.renguangli.rportal.shiro;

import com.renguangli.rportal.RportalApplication;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * ShiroService
 *
 * @author renguangli 2018/8/2 13:44
 * @since JDK 1.8
 */
@Service("shiroService")
public class ShiroService {

    @Resource
    private ShiroRealm shiroRealm;

    public void updatePermission() {
        AbstractShiroFilter shiroFilter = RportalApplication.ctx.getBean("shiroFilter", AbstractShiroFilter.class);
        synchronized (shiroFilter) {
            // 获取过滤管理器
            PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
            DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();
            manager.getFilterChains().clear();// 清空初始权限配置
            Map<String, String> chains = shiroRealm.doGetFilterChainDefinitionMap(); // 重新获取权限资源
            chains.forEach(manager::createChain);
        }
    }


}
