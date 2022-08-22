package com.situ.mall.service.impl;

import com.situ.mall.mapper.UserMapper;
import com.situ.mall.pojo.User;
import com.situ.mall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String name, String password) {
        return userMapper.login(name, password);
    }
}
