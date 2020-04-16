package com.example.demo.controller;

import com.example.demo.entity.Duty;
import com.example.demo.service.DutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("duty")
public class DutyController {
    @Autowired
    private DutyService dutyService;

    @RequestMapping("findAllDuty")
    public List<Duty> findAllDuty(){
        return dutyService.findAllDuty();
    }
    @RequestMapping("findDutyByTime/{duty_time}")
    public Duty findDutyByTime(String duty_time){
        return dutyService.findDutyByTime(duty_time);
    }
    @RequestMapping("findDutyByName/{doctor_name}")
    public Duty findDutyByName(String doctor_name){
        return dutyService.findDutyByName(doctor_name);
    }
}
