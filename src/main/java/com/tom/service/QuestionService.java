package com.tom.service;

import com.tom.model.Question;
import java.util.List;

public interface QuestionService extends BasicService<Question> {

    /**
     * 更新问题内容时使用
     * @param record 传递的值对象
     * @return 更新的条数
     */
    int updateWithBLOBs(Question record);

    /**
     * 查询所有问题
     * @return 问题列表
     */
    List<Question> findQuestions();
}
