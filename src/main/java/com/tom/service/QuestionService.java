package com.tom.service;

import com.tom.model.Question;
import java.util.List;

public interface QuestionService extends BasicService<Question> {

    int updateWithBLOBs(Question record);

    List<Question> findQuestions();
}
