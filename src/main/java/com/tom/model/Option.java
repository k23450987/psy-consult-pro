package com.tom.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 测评问题选项 POJO
 */
@Getter
@Setter
@ToString
public class Option {

    private Integer id;
    private Integer quizId;      // 所属问题 ID
    private String text;         // 选项内容
    private Integer nextQuizId;  // 点击该选项后跳转到的题目
}
