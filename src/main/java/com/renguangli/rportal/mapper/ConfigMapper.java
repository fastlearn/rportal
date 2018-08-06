package com.renguangli.rportal.mapper;

import com.renguangli.rportal.bean.Config;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ConfigMapper
 *
 * @author renguangli 2018/8/1 10:19
 * @since JDK 1.8
 */
public interface ConfigMapper {

    boolean save(Config config);

    Config getConfig(@Param("name") String name);

    boolean update(@Param("config") Config config);

    List<Config> listConfig(@Param("config") Config config);
}
