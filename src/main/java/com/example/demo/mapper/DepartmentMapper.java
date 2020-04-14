package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    @Select("select * from department_info;")
    List<Department> findAllDepartment();

    @Insert("insert into department_info(department_name,department_content)" +
            "values(#{department_name},#{department_content})")
    void InsertDepartment(Department department);

    @Delete("delete from department_info where department_name = #{department_name};")
    int deleteDepartmentByName(String department_name);

    @Update("update department_info set department_name = #{department_name}," +
            "department_content = #{department_content} where department_id = #{department_id}")
    void updateDepartment(Department department);
}
