package com.tom.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 测评问题 POJO
 */
@Getter
@Setter
@ToString
public class Quiz {

    private Integer id;
    private String title;             // 测评问题标题
    private Boolean flag;             // 是否是第一题（唯一）
    private List<Option> optionList;  // 关联查询该问题下的所有选项
}
