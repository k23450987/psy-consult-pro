package com.tom.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户角色 POJO
 */
@Getter
@Setter
@ToString
public class Role {

    private Integer id;
    private String name;  // 角色名称 存在两种 系统管理员（ROLE_ADMIN）和普通用户（ROLE_USER）
}
