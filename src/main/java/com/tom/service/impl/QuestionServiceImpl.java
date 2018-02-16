package com.tom.service.impl;

import com.tom.dao.QuestionMapper;
import com.tom.model.Question;
import com.tom.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl extends BasicServiceImpl<Question> implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public int updateWithBLOBs(Question record) {
        return questionMapper.updateByPrimaryKeyWithBLOBs(record);
    }
}
