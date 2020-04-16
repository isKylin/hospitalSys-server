package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.Department;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> findAllDepartment(){
        return departmentMapper.findAllDepartment();
    }

    @Override
    public void insertDepartment(Department department){
        departmentMapper.InsertDepartment(department);
    }

    @Override
    public int deleteDepartmentByName(String department_name){
        return departmentMapper.deleteDepartmentByName(department_name);
    }

    @Override
    public void updateDepartment(Department department){
        departmentMapper.updateDepartment(department);
    }

    @Override
    public Department finDepartmentByName(String department_name){
        return departmentMapper.findDepartmentByName(department_name);
    }
}
