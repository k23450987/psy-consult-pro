package com.tom.service;

import com.tom.model.Quiz;
import java.util.List;

public interface QuizService extends BasicService<Quiz> {

    /**
     * 根据测评问题的编号查询（包含选项）
     * @param id 测评问题的编号
     * @return 测评问题
     */
    Quiz getQuiz(Integer id);

    /**
     * 条件查询所有测评问题
     * @return 测评问题列表
     */
    List<Quiz> findQuizs(Quiz quiz);
}
