package com.tom.dao;

/**
 * 基础 Mapper
 * @param <T> 泛型
 */
public interface BasicMapper<T> {

    int deleteByPrimaryKey(Integer id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);
}
