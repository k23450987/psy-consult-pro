package com.tom.dao;

import com.tom.model.Quiz;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuizMapper extends BasicMapper<Quiz> {

    Quiz getQuiz(Integer id);

    List<Quiz> findQuizs(Quiz quiz);
}
