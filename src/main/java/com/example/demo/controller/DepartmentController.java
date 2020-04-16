package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @RequestMapping("findAllDepartment")
    public List<Department> findAllDepartment(){
        return departmentService.findAllDepartment();
    }

    @RequestMapping("insertDepartment")
    public void insertDepartment(Department department){
        departmentService.insertDepartment(department);
    }

    @RequestMapping("deleteDepartmentByName/{department_name}")
    public int deleteDepartmentByName(String department_name){
        return departmentService.deleteDepartmentByName(department_name);
    }

    @RequestMapping("updateDepartment/{department_id}")
    public void updateDepartment(Department department){
        departmentService.updateDepartment(department);
    }

    @RequestMapping("findDepartmentByName/{department_name}")
    public Department finDepartmentByName(String department_name){
        return departmentService.finDepartmentByName(department_name);
    }
}
