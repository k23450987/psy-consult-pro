package com.tom.service.impl;

import com.tom.dao.QuestionMapper;
import com.tom.model.Question;
import com.tom.service.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = {Exception.class})
public class QuestionServiceImpl extends BasicServiceImpl<Question> implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public int updateWithBLOBs(Question record) {
        return questionMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public List<Question> findQuestions() {
        return questionMapper.findQuestions();
    }
}
