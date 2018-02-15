package com.tom.model;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = -3658273734829759865L;

    private int id;
    private String username;
    private String password;
    private List<Role> roles;

}
