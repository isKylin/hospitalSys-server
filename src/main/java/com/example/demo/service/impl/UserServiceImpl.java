package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public int userRegister(User user){
        return userMapper.userRegister(user);
    }

    @Override
    public int userUpdatePwd(User user){
        try {
            if(user == null || user.getUserId() < 1 || "".equals(user.getUserId())){
                return 0;
            }
            System.out.println("success");
            return userMapper.userUpdatePwd(user);
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public UserDTO userLogin(String userName, String userPassword) {
        return userMapper.userLogin(userName, userPassword);
    }
}
