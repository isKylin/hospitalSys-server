package com.example.demo.mapper;

import com.example.demo.entity.Department;
import com.example.demo.entity.Doctor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DoctorMapper {
    // 查询所有医生信息
    @Select("select * from doctor_info;")
    List<Doctor> findAllDoctor();

    // 添加医生信息
    @Insert("insert into doctor_info(doctor_name,doctor_department,doctor_sex,doctor_age,doctor_position," +
            "doctor_phone,doctor_speciality,doctor_achievement)" +
            "values(#{doctor_name},#{doctor_department},#{doctor_sex},#{doctor_age},#{doctor_position}," +
            "#{doctor_phone},#{doctor_speciality},#{doctor_achievement})")
    void insertDoctor(Doctor doctor);

    // 删除医生信息
    @Delete("delete from doctor_info where doctor_name = #{doctor_name};")
    int deleteDoctorByName(String doctor_name);

    // 修改医生信息
    @Update("update doctor_info set doctor_name = #{doctor_name}," +
            "doctor_department = #{doctor_department}, doctor_sex = #{doctor_sex}, " +
            "doctor_age = #{doctor_age}, doctor_position = #{doctor_position}," +
            "doctor_phone = #{doctor_phone}, doctor_speciality = #{doctor_speciality}," +
            "doctor_achievement = #{doctor_achievement} where department_id = #{department_id}")
    void updateDoctor(Doctor doctor);
    
    // 根据医生名字查询医生信息
    @Select("select * from doctor_info where doctor_name = #{doctor_name}")
    Doctor findDoctorByName(String doctor_name);
}
