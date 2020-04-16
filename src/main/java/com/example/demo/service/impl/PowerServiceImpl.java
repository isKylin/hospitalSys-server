package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.PowerMapper;
import com.example.demo.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PowerServiceImpl implements PowerService {
    @Autowired
    private PowerMapper powerMapper;

    @Override
    public List<User> findAllPower(){
        return powerMapper.findAllPower();
    }

    @Override
    public void updateUserPower(User user){
        powerMapper.updateUserPower(user);
    }
}
