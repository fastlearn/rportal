package com.renguangli.rportal.mapper;

import com.renguangli.rportal.bean.Config;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ConfigMapper
 *
 * @author renguangli 2018/8/1 10:19
 * @since JDK 1.8
 */
public interface ConfigMapper {

    boolean save(Config config);

    boolean update(@Param("config")Config config);

    List<Config> listConfig(@Param("names") String... names);
}
