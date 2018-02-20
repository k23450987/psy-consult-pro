package com.tom.dao;

import com.tom.model.Option;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OptionMapper extends BasicMapper<Option> {

    /**
     * 条件查询所有问题选项
     * @return 问题选项列表
     */
    List<Option> findOptions(Option option);

    /**
     * 条件查询所有问题选项
     * @return 问题选项列表
     */
    List<Option> findOptionsByQuizId(Integer quizId);
}
