package com.tom.model;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role implements Serializable {

    private static final long serialVersionUID = -3197678051582892163L;

    private int id;
    private String name;

}
