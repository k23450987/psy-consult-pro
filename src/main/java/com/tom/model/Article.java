package com.tom.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 网站文章 POJO
 */
@Getter
@Setter
@ToString
public class Article {

    private Integer id;
    private String title;       // 文章题目
    private String content;     // 文章内容
    private Date releaseDate;   // 发布时间
    private Integer clickTime;  // 点击数
}
