package com.example.demo.controller;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @RequestMapping("findAllDoctor")
    public List<Doctor> findAllDoctor(){
        return doctorService.findAllDoctor();
    }

    @RequestMapping("insertDoctor")
    public void insertDoctor(Doctor doctor){
        doctorService.insertDoctor(doctor);
    }

    @RequestMapping("deleteDoctorByName")
    public int deleteDoctorByName(String doctor_name){
        return doctorService.deleteDoctorByName(doctor_name);
    }

    @RequestMapping("updateDoctor")
    public void updateDoctor(Doctor doctor){
        doctorService.updateDoctor(doctor);
    }

    @RequestMapping("findDoctorByName")
    public Doctor findDoctorByName(String doctor_name){
        return doctorService.findDoctorByName(doctor_name);
    }
}
