package com.example.demo.service.impl;

import com.example.demo.entity.Doctor;
import com.example.demo.mapper.DoctorMapper;
import com.example.demo.service.DoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Resource
    private DoctorMapper doctorMapper;

    @Override
    public int createDoctor(Doctor doctor){
        return  doctorMapper.createDoctor(doctor);
    }

    @Override
    public int deleteDoctor(Integer doctorId){
        if(doctorId < 1) {
            return 0;
        }
        return doctorMapper.deleteDoctor(doctorId);
    }

    @Override
    public int updateDoctor(Doctor doctor){
        try {
            if(doctor == null || doctor.getDoctorId() < 1 || "".equals(doctor.getDoctorId())){
                return 0;
            }
            System.out.println("success");
            return doctorMapper.updateDoctor(doctor);
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Doctor> doctorList(){
        return doctorMapper.doctorList();
    }
}
