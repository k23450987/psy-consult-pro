package com.tom.dao;

import com.tom.model.Option;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OptionMapper extends BasicMapper<Option> {

    List<Option> findOptions(Option option);

    List<Option> findOptionsByQuizId(Integer quizId);
}
