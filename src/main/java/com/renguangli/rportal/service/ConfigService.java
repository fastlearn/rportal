package com.renguangli.rportal.service;

import com.renguangli.rportal.bean.Config;

import java.util.List;

/**
 * ConfigService
 *
 * @author renguangli 2018/8/1 10:50
 * @since JDK 1.8
 */
public interface ConfigService {

    Config getConfig(String name);

    List<Config> listConfig(Config config, int page, int limit);

    int countConfig(Config config);

    boolean saveConfig(Config config);

    boolean updateConfig(Config config);

    boolean deleteConfig(String id);

    boolean batchDeleteConfig(Integer[] ids);
}
