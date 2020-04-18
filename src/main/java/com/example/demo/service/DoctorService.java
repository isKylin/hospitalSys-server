package com.example.demo.service;

import com.example.demo.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> findAllDoctor();
    void insertDoctor(Doctor doctor);
    int deleteDoctorByName(String doctor_name);
    void updateDoctor(Doctor doctor);
    Doctor findDoctorByName(String doctor_name);
}
