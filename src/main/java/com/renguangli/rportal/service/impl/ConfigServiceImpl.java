package com.renguangli.rportal.service.impl;

import com.renguangli.rportal.pojo.Config;
import com.renguangli.rportal.mapper.ConfigMapper;
import com.renguangli.rportal.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public Config getConfig(Config config) {
        return configMapper.getConfig(config);
    }

    @Override
    public List<Config> listConfig(Config config, int page, int limit) {
        page = (page - 1) * limit;
        return configMapper.listConfig(config, page, limit);
    }

    @Override
    public int countConfig(Config config) {
        return configMapper.countConfig(config);
    }

    @Override
    public boolean deleteConfig(Integer id) {
        return configMapper.delete(id);
    }

    @Override
    public boolean batchDeleteConfig(Integer[] ids) {
        return configMapper.batchDelete(ids);
    }

    @Override
    public boolean saveConfig(Config config) {
        //设置时间
        config.setUpdateDatetime(LocalDateTime.now());
        return configMapper.save(config);
    }

    @Override
    public boolean updateConfig(Config config) {
        return configMapper.update(config);
    }

}
