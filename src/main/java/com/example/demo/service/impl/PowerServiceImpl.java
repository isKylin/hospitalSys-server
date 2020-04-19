package com.example.demo.service.impl;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.User;
import com.example.demo.mapper.PowerMapper;
import com.example.demo.service.PowerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class PowerServiceImpl implements PowerService {
    @Resource
    private PowerMapper powerMapper;

    @Override
    public int updatePower(User user){
        try {
            if(user == null || user.getUserId() < 1 || "".equals(user.getUserId())){
                return 0;
            }
            System.out.println("success");
            return powerMapper.updatePower(user);
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<User> powerList(){
        return powerMapper.powerList();
    }

}
