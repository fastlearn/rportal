package com.renguangli.rportal.service;

import java.util.Map;

public interface ShiroService {

    void updateFilterChainDefinitionMap();

    Map<String,String> getFilterChainDefinitionMap();
}
