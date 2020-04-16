package com.example.demo.mapper;

import com.example.demo.entity.Duty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DutyMapper {
    // 查询所有值班信息
    @Select("select * from duty_info")
    List<Duty> findAllDuty();
    // 根据时间段查询值班信息
    @Select("select * from duty_info where duty_time = #{duty_time}")
    Duty findDutyByTime(String duty_time);
    // 根据医生名字查询值班信息
    @Select("select * from duty_info where doctor_name = #{doctor_name}")
    Duty findDutyByName(String doctor_name);
}
