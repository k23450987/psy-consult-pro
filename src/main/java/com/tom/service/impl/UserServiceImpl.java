package com.tom.service.impl;

import com.tom.dao.UserMapper;
import com.tom.model.User;
import com.tom.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = {Exception.class})
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

    @Override
    public List<User> findUsers() {
        return userMapper.findUsers();
    }
}
