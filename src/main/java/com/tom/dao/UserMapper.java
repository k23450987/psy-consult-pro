package com.tom.dao;

import com.tom.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User findByUsernameAndPassword(User user);

    User findByUsername(@Param("username") String username);
}
