package com.renguangli.rportal.mapper;

import com.renguangli.rportal.pojo.Config;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ConfigMapper
 *
 * @author renguangli 2018/8/1 10:19
 * @since JDK 1.8
 */
public interface ConfigMapper extends BaseMapper<Config, Integer> {

    String getConfig(@Param("name") String name);

    List<Config> listConfig(@Param("pojo") Config config, @Param("page") int page, @Param("limit") int limit);

    int countConfig(@Param("pojo") Config config);

}
