package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.entity.Result;
import com.example.demo.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/department")
@RestController
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    /**
     * 新增部门信息
     *
     * @param department 部门实体信息
     * @return Result
     */
    @RequestMapping(value = "create",method = RequestMethod.POST)
    public Result departmentCreate(@RequestBody Department department) {
        int num = departmentService.createDepartment(department);
        Result result = new Result();
        if (num > 0) {
            result.setCode(200);
            result.setMessage("插入数据成功");
            return result;
        } else {
            result.setCode(500);
            result.setMessage("插入数据失败");
            return result;
        }
    }

    /**
     * 删除部门信息
     *
     * @param departmentId 部门实体编号
     * @return Result
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Result departmentDelete(Integer departmentId) {
        int num = departmentService.deleteDepartment(departmentId);
        Result result = new Result();
        if(num > 0) {
            result.setCode(200);
            result.setMessage("数据删除成功");
            return result;
        } else {
            result.setCode(500);
            result.setMessage("数据删除失败");
            return result;
        }
    }

    /**
     * 修改部门信息
     *
     * @param department 部门实体信息
     * @return Result
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Result departmentUpdate(@RequestBody Department department) {
        int num = departmentService.updateDepartment(department);
        Result result = new Result();
        if (num > 0) {
            result.setCode(200);
            result.setMessage("数据修改成功");
            return result;
        } else {
            result.setCode(500);
            result.setMessage("数据修改失败");
            return result;
        }
    }

    /**
     * 查询所有部门信息
     *
     * @return List<Department>
     */
    @RequestMapping(value = "find",method = RequestMethod.POST)
    public Result listDepartment() {
        List<Department> departmentList = departmentService.departmentList();
        Result result = new Result();
        if (departmentList != null) {
            result.setCode(200);
            result.setMessage("查询成功");
            result.setData(departmentList);
            return result;
        } else {
            result.setCode(500);
            result.setMessage("查询失败");
            return result;
        }
    }
}
