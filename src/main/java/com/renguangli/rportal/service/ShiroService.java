package com.renguangli.rportal.service;

import java.util.Map;

/**
 * ShiroService
 *
 * @author renguangli 2018/8/2 13:25
 * @since JDK 1.8
 */
public interface ShiroService {

    void updateFilterChainDefinitionMap();

    Map<String,String> getFilterChainDefinitionMap();
}
