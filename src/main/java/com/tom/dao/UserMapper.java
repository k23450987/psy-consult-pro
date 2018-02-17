package com.tom.dao;

import com.tom.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BasicMapper<User> {

    User findByUsernameAndPassword(User user);

    User findByUsername(@Param("username") String username);

    List<User> findUsers();
}
