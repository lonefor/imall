package com.situ.mall.service;


import com.situ.mall.pojo.User;

public interface IUserService {

    User login(String name, String password);
}
