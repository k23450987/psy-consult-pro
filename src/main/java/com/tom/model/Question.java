package com.tom.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户咨询问题 POJO
 */
@Getter
@Setter
@ToString
public class Question {

    private Integer id;
    private String title;    // 问题题目
    private String content;  // 问题内容
    private Date askDate;    // 提问时间
    private Integer userId;  // 提问人
    private String answer;   // 回复
}
