package com.renguangli.rportal.service.impl;

import com.renguangli.rportal.bean.Config;
import com.renguangli.rportal.mapper.ConfigMapper;
import com.renguangli.rportal.mapper.UserMapper;
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
    public List<Config> listConfig(Config config, int page, int limit) {
        return configMapper.listConfig(config, page, limit);
    }

    @Override
    public int countConfig(Config config) {
        return configMapper.countConfig(config);
    }

    @Override
    public boolean deleteConfig(String id) {
        return configMapper.deleteConfig(id);
    }

    @Override
    public boolean batchDeleteConfig(Integer[] ids) {
        return configMapper.batchDeleteConfig(ids);
    }

    @Override
    public boolean updateConfig(List<Config> configs) {
        configs.forEach(configMapper::updateConfig);
        return true;
    }

}
