package com.tom.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户与角色的关联
 */
@Getter
@Setter
@ToString
public class UserRole {

    private Integer id;
    private Integer userId;
    private Integer roleId;
}
