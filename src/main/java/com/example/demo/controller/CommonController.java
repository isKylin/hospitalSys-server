package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("common")
public class CommonController {
    @Autowired
    private UserService userService;

    @RequestMapping("userLogin")
    public void userLogin(User user){
        userService.userLogin(user);
    }

    @RequestMapping("userRegister")
    public int userRegister(User user){
        return userService.userRegister(user);
    }

    @RequestMapping("userUpdatePwd")
    public void userUpdatePwd(User user){
        userService.userUpdatePwd(user);
    }
}
