package com.renguangli.rportal.service;

import com.renguangli.rportal.pojo.Config;

import java.util.List;

/**
 * ConfigService
 *
 * @author renguangli 2018/8/1 10:50
 * @since JDK 1.8
 */
public interface ConfigService {

    String getConfig(String name);

    List<Config> listConfig(Config config, int page, int limit);

    int countConfig(Config config);

    boolean saveConfig(Config config);

    boolean updateConfig(Config config);

    boolean deleteConfig(Integer id);

    boolean batchDeleteConfig(Integer[] ids);
}
