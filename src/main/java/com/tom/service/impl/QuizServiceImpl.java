package com.tom.service.impl;

import com.tom.dao.QuizMapper;
import com.tom.model.Quiz;
import com.tom.service.QuizService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = {Exception.class})
public class QuizServiceImpl extends BasicServiceImpl<Quiz> implements QuizService {

    @Autowired
    private QuizMapper quizMapper;

    @Override
    public Quiz getQuiz(Integer id) {
        return quizMapper.getQuiz(id);
    }

    @Override
    public List<Quiz> findQuizs(Quiz quiz) {
        return quizMapper.findQuizs(quiz);
    }
}
