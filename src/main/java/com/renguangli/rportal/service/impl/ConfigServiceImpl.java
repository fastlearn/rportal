package com.renguangli.rportal.service.impl;

import com.renguangli.rportal.bean.Config;
import com.renguangli.rportal.mapper.ConfigMapper;
import com.renguangli.rportal.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * ConfigServiceImpl
 *
 * @author renguangli 2018/8/1 10:51
 * @since JDK 1.8
 */
@Service("configService")
public class ConfigServiceImpl implements ConfigService {

    private final ConfigMapper configMapper;

    @Autowired
    public ConfigServiceImpl(ConfigMapper configMapper) {
        this.configMapper = configMapper;
    }

    @Override
    public Config getConfig(String name) {
        return configMapper.getConfig(name);
    }

    @Override
    public List<Config> listConfig(Config config) {
        return configMapper.listConfig(config);
    }

    @Override
    public boolean updateConfig(List<Config> configs) {
        configs.forEach(configMapper::update);
        return true;
    }
}
