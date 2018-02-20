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
    private Integer quizId;
    private String text;
    private Integer nextQuizId;
}
