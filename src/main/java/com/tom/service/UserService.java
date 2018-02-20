package com.tom.service;

import com.tom.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserService extends BasicService<User> {

    /**
     * 根据用户名和密码查找
     * @param user 值对象
     * @return 用户实体
     */
    User findByUsernameAndPassword(User user);

    /**
     * 根据用户名查找（登录时、添加用户时使用）
     * @param username 用户名
     * @return 用户实体
     */
    User findByUsername(@Param("username") String username);

    /**
     * 查询所有用户列表
     * @return 用户列表
     */
    List<User> findUsers();
}
