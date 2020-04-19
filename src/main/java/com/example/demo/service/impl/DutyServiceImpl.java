package com.example.demo.service.impl;

import com.example.demo.entity.Duty;
import com.example.demo.mapper.DutyMapper;
import com.example.demo.service.DutyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DutyServiceImpl implements DutyService {
    @Resource
    private DutyMapper dutyMapper;

    @Override
    public List<Duty> findAllDuty(){
        return  dutyMapper.findAllDuty();
    }

}
