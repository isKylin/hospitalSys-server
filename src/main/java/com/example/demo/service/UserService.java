package com.example.demo.service;


import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

public interface UserService {
    int userRegister(User user);
    int userUpdatePwd(User user);
    UserDTO userLogin(String userName, String userPassword);
}
