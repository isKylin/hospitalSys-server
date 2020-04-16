package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("power")
public class PowerController {
    @Autowired
    private PowerService powerService;

    @RequestMapping("/findAllPower")
    public List<User> findAllPower(){
        return powerService.findAllPower();
    }

    @RequestMapping("updateUserPower")
    public void updateUserPower(User user){
        powerService.updateUserPower(user);
    }
}
