package com.tom.service.impl;

import com.tom.dao.BasicMapper;
import com.tom.service.BasicService;
import javax.annotation.Resource;

/**
 * 基础服务实现类
 * @param <T> 泛型
 */
public class BasicServiceImpl<T> implements BasicService<T> {

    @Resource
    private BasicMapper<T> dao;

    @Override
    public int delete(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T t) {
        return dao.insert(t);
    }

    @Override
    public int insertSelective(T t) {
        return dao.insertSelective(t);
    }

    @Override
    public T get(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int updateSelective(T t) {
        return dao.updateByPrimaryKeySelective(t);
    }

    @Override
    public int update(T t) {
        return dao.updateByPrimaryKey(t);
    }
}
