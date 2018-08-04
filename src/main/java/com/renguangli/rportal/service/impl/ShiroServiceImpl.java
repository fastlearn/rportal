package com.renguangli.rportal.service.impl;

import com.renguangli.rportal.RportalApplication;
import com.renguangli.rportal.bean.Permission;
import com.renguangli.rportal.service.PermissionService;
import com.renguangli.rportal.service.ShiroService;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service("shiroService")
public class ShiroServiceImpl implements ShiroService {

    private static Object lock = new Object();

    @Resource
    private PermissionService permissionService;

    public synchronized void updateFilterChainDefinitionMap() {
        AbstractShiroFilter shiroFilter = RportalApplication.ctx.getBean("shiroFilter", AbstractShiroFilter.class);
        // 获取过滤管理器
        PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
        DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();
        manager.getFilterChains().clear();// 清空初始权限配置
        Map<String, String> chains = getFilterChainDefinitionMap(); // 重新获取权限资源
        chains.forEach(manager::createChain);
    }

    /**
     * 构造shiro过滤链配置
     */
    public Map<String,String> getFilterChainDefinitionMap(){
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 从数据库获取url权限配置
        List<Permission> permissions = permissionService.listPermission(null);
        for (Permission permission : permissions) {
            filterChainDefinitionMap.put(permission.getUrl(),permission.getPermission());
        }
        return filterChainDefinitionMap;
    }
}
