package com.example.demo.mapper;

import com.example.demo.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    // 显示所有部门信息
    @Select("select * from department_info;")
    List<Department> findAllDepartment();
    // 添加部门信息
    @Insert("insert into department_info(department_name,department_content)" +
            "values(#{department_name},#{department_content})")
    void InsertDepartment(Department department);
    // 删除部门信息
    @Delete("delete from department_info where department_name = #{department_name};")
    int deleteDepartmentByName(String department_name);
    // 修改部门信息
    @Update("update department_info set department_name = #{department_name}," +
            "department_content = #{department_content} where department_id = #{department_id}")
    void updateDepartment(Department department);
    // 根据部门名称查询部门信息
    @Select("select * from department_info where department_name = #{department_name}")
    Department findDepartmentByName(String department_name);
}
