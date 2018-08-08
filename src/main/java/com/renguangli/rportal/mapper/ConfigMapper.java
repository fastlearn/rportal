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

    Config getConfig(@Param("name") String name);

    List<Config> listConfig(@Param("config") Config config, @Param("page") int page, @Param("limit") int limit);

    int countConfig(@Param("config") Config config);

    boolean saveConfig(@Param("config") Config config);

    boolean deleteConfig(@Param("id") String id);

    boolean batchDeleteConfig(@Param("ids") Integer[] ids);

    boolean updateConfig(@Param("config") Config config);

}
