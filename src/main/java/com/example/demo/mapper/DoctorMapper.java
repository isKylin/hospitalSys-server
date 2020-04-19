package com.example.demo.mapper;

import com.example.demo.entity.Doctor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DoctorMapper {
    /**
     * 新增医生信息
     * @param doctor 医生实体信息
     * @return int
     */
    @Insert("insert into doctor_info(doctor_name,doctor_department,doctor_sex,doctor_age,doctor_position," +
            "doctor_phone,doctor_speciality,doctor_achievement)" +
            "values(#{doctorName},#{doctorDepartment},#{doctorSex},#{doctorAge},#{doctorPosition}," +
            "#{doctorPhone},#{doctorSpeciality},#{doctorAchievement})")
    int createDoctor(Doctor doctor);

    /**
     * 删除医生信息
     * @param doctorId 医生编号
     * @return int
     */
    @Delete("delete from doctor_info where doctor_id = #{doctorId};")
    int deleteDoctor(@Param("doctorId") Integer doctorId);

    /**
     * 修改医生信息
     * @param doctor 医生实体信息
     * @return int
     */
    @Update("update doctor_info set doctor_name = #{doctorName}," +
            "doctor_department = #{doctorDepartment}, doctor_sex = #{doctorSex}, " +
            "doctor_age = #{doctorAge}, doctor_position = #{doctorPosition}," +
            "doctor_phone = #{doctorPhone}, doctor_speciality = #{doctorSpeciality}," +
            "doctor_achievement = #{doctorAchievement} where department_id = #{departmentId}")
    int updateDoctor(Doctor doctor);

    /**
     * 查询所有信息
     * @return List<Doctor>
     */
    @Select("select * from doctor_info")
    List<Doctor> doctorList();
}
