package com.tom.service;

import com.tom.model.Option;
import java.util.List;

public interface OptionService extends BasicService<Option> {

    List<Option> findOptions(Option option);

    List<Option> findOptionsByQuizId(Integer quizId);
}
