package com.tom.service.impl;

import com.tom.dao.UserMapper;
import com.tom.model.User;
import com.tom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BasicServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsernameAndPassword(User user) {
        return userMapper.findByUsernameAndPassword(user);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}