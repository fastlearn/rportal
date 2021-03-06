package com.renguangli.rportal.service.impl;

import com.renguangli.rportal.mapper.PermissionMapper;
import com.renguangli.rportal.pojo.Permission;
import com.renguangli.rportal.service.PermissionService;
import com.renguangli.rportal.service.ShiroService;
import com.renguangli.rportal.util.WebUtils;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * ShiroServiceImpl
 *
 * @author renguangli 2018/8/2 13:25
 * @since JDK 1.8
 */
@Service("shiroService")
public class ShiroServiceImpl implements ShiroService {

    private final PermissionMapper permissionMapper;

    @Autowired
    public ShiroServiceImpl(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    public synchronized void updateFilterChainDefinitionMap() {
        AbstractShiroFilter shiroFilter = WebUtils.getApplicationContext().getBean("shiroFilter", AbstractShiroFilter.class);
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
        List<Permission> permissions = permissionMapper.list();
        permissions.forEach(permission -> {
            String perm = permission.getPermission();
            if (!permission.isFixed()) {
                perm = "perms[" + perm + "]";
            }
            filterChainDefinitionMap.put(permission.getUrl(), perm);
        });

        return filterChainDefinitionMap;
    }
}
