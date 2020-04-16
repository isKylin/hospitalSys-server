package com.example.demo.service;

import com.example.demo.entity.Duty;

import java.util.List;

public interface DutyService {
    List<Duty> findAllDuty();
    Duty findDutyByTime(String duty_time);
    Duty findDutyByName(String doctor_name);
}
