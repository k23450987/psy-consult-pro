package com.tom.service;

import com.tom.model.Option;
import java.util.List;

public interface OptionService extends BasicService<Option> {

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
