package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;

public interface DepartmentService {
    List<Department> findAllDepartment();
    void insertDepartment(Department department);
    int deleteDepartmentByName(String department_name);
    void updateDepartment(Department department);
    Department finDepartmentByName(String department_name);
}
