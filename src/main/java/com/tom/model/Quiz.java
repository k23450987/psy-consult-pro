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
    private String title;
    private Boolean flag;
    private List<Option> optionList;
}
