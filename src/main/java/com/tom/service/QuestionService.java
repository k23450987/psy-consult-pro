package com.tom.service;

import com.tom.model.Question;

public interface QuestionService extends BasicService<Question> {

    int updateWithBLOBs(Question record);
}
