package com.example.demo.service.impl;

import com.example.demo.entity.Duty;
import com.example.demo.mapper.DutyMapper;
import com.example.demo.service.DutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DutyServiceImpl implements DutyService {
    @Autowired
    private DutyMapper dutyMapper;

    @Override
    public List<Duty> findAllDuty(){
        return  dutyMapper.findAllDuty();
    }

    @Override
    public Duty findDutyByTime(String duty_time){
        return dutyMapper.findDutyByTime(duty_time);
    }

    @Override
    public Duty findDutyByName(String doctor_name){
        return dutyMapper.findDutyByName(doctor_name);
    }
}
