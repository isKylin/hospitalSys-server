package com.example.demo.mapper;

import com.example.demo.entity.Duty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DutyMapper {
    /**
     * 查询所有权限
     * @return List<Duty>
     */
    @Select("select * from duty_info")
    List<Duty> findAllDuty();
}
