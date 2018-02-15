package com.tom.dao;

import com.tom.model.Question;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper extends BasicMapper<Question> {

    int updateByPrimaryKeyWithBLOBs(Question record);
}
