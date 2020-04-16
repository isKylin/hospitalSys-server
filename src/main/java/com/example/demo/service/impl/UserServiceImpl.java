package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void userLogin(User user){
        User u = userMapper.userLogin(user);
        String power = u.getUser_role();
        if ("1".equals(power)) {
            log.info("普通用户");
        } else if ("2".equals(power)) {
            log.info("医院");
        } else if ("3".equals(power)) {
            log.info("部门管理员");
        } else if ("4".equals(power)) {
            log.info("超级管理员");
        }
    }

    @Override
    public int userRegister(User user){
        return userMapper.userRegister(user);
    }

    @Override
    public void userUpdatePwd(User user){
        userMapper.userUpdatePwd(user);
    }
}
