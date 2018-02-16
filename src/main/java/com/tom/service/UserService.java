package com.tom.service;

import com.tom.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserService extends BasicService<User> {

    User findByUsernameAndPassword(User user);

    User findByUsername(@Param("username") String username);
}
