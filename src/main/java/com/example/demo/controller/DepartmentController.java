package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.mapper.DepartmentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentMapper departmentMapper;


    @RequestMapping("findAllDepartment")
    public List<Department> findAllDepartment(){
        return departmentMapper.findAllDepartment();
    }

    @RequestMapping("insertDepartment")
    public void insertDepartment(Department department){
        departmentMapper.InsertDepartment(department);
    }

    @RequestMapping("deleteDepartmentByName/{department_name}")
    public int deleteDepartmentByName(@PathVariable String department_name){
        return departmentMapper.deleteDepartmentByName(department_name);
    }

    @RequestMapping("updateDepartment/{department_id}")
    public void updateDepartment(Department department){
        departmentMapper.updateDepartment(department);
    }
}
