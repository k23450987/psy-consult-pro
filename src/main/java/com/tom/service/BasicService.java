package com.tom.service;

/**
 * 基础服务类
 *
 * @param <T> 泛型
 */
public interface BasicService<T> {

    int delete(Integer id);

    int insert(T t);

    int insertSelective(T t);

    T get(Integer id);

    int updateSelective(T t);

    int update(T t);
}
