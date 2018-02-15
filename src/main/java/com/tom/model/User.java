package com.tom.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户账户 POJO
 */
@Getter
@Setter
@ToString
public class User {

    private Integer id;
    private String username;   // 用户名
    private String password;   // 密码
    private String name;       // 姓名
    private Integer sex;       // 性别 1:男 2:女
    private Integer age;       // 年龄
    private List<Role> roles;  // 该账户的权限
}
