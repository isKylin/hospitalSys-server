package com.example.demo.service;


import com.example.demo.entity.User;

public interface UserService {
    void userLogin(User user);
    int userRegister(User user);
    void userUpdatePwd(User user);
}
