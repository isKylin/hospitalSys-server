package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;
import org.apache.ibatis.annotations.Param;

public interface DepartmentService {
    int createDepartment(Department department);
    int deleteDepartment(@Param("departmentID") Integer departmentID);
    int updateDepartment(Department department);
    List<Department> departmentList();
}
