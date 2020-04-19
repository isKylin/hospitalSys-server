package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.entity.Department;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;

    /**
     * 新增部门信息
     * @param department 部门实体信息
     * @return int
     */
    @Override
    public int createDepartment(Department department) {
        return departmentMapper.createDepartment(department);
    }

    /**
     * 删除部门信息
     * @param departmentId 部门编号
     * @return int
     */
    @Override
    public int deleteDepartment(Integer departmentId){
        if(departmentId < 1){
            return 0;
        }
        return  departmentMapper.deleteDepartment(departmentId);
    }

    /**
     * 修改部门信息
     * @param department 部门实体信息
     * @return int
     */
    @Override
    public int updateDepartment(Department department) {
        try {
            if(department == null || department.getDepartmentId() < 1 || "".equals(department.getDepartmentId())){
                return 0;
            }
            System.out.println("success");
            return departmentMapper.updateDepartment(department);
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 查询所有信息
     * @return List<Department>
     */
    @Override
    public List<Department> departmentList(){
        return departmentMapper.departmentList();
    }
}
