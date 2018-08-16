package com.renguangli.rportal.mapper;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * 数据库基础操作
 * @param <T>
 * @param <ID>
 */
public interface BaseMapper<T, ID extends Serializable> {

    T get(@Param("pojo") T t);

    List<T> list();

    boolean save(@Param("pojo") T t);

    boolean batchSave(@Param("pojos") List<T> ts);

    boolean delete(@Param("id")ID id);

    boolean batchDelete(@Param("ids") ID[] ids);

    boolean update(@Param("pojo") T t);

}
