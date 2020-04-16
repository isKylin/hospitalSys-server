package com.example.demo.service.impl;

import com.example.demo.entity.Doctor;
import com.example.demo.mapper.DoctorMapper;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public List<Doctor> findAllDoctor(){
        return doctorMapper.findAllDoctor();
    }

    @Override
    public void insertDoctor(Doctor doctor){
        doctorMapper.insertDoctor(doctor);
    }

    @Override
    public int deleteDoctorByName(String doctor_name){
        return doctorMapper.deleteDoctorByName(doctor_name);
    }

    @Override
    public void updateDoctor(Doctor doctor){
        doctorMapper.updateDoctor(doctor);
    }

    @Override
    public Doctor findDoctorByName(String doctor_name){
        return doctorMapper.findDoctorByName(doctor_name);
    }
}
