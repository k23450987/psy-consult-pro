package com.tom.service;

import com.tom.model.Quiz;
import java.util.List;

public interface QuizService extends BasicService<Quiz> {

    Quiz getQuiz(Integer id);

    List<Quiz> findQuizs(Quiz quiz);
}
