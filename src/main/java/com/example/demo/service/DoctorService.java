package com.example.demo.service;

import com.example.demo.entity.Doctor;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DoctorService {
    int createDoctor(Doctor doctor);
    int deleteDoctor(@Param("doctorId") Integer doctorId);
    int updateDoctor(Doctor doctor);
    List<Doctor> doctorList();
}
