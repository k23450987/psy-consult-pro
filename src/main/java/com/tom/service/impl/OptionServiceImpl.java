package com.tom.service.impl;

import com.tom.dao.OptionMapper;
import com.tom.model.Option;
import com.tom.service.OptionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = {Exception.class})
public class OptionServiceImpl extends BasicServiceImpl<Option> implements OptionService {

    @Autowired
    private OptionMapper optionMapper;

    @Override
    public List<Option> findOptions(Option option) {
        return optionMapper.findOptions(option);
    }

    @Override
    public List<Option> findOptionsByQuizId(Integer quizId) {
        return optionMapper.findOptionsByQuizId(quizId);
    }
}
