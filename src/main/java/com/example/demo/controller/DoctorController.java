package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Result;
import com.example.demo.service.DoctorService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("doctor")
@RestController
public class DoctorController {

    @Resource
    private DoctorService doctorService;

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public Result doctorCreate(@RequestBody Doctor doctor) {
        int num = doctorService.createDoctor(doctor);
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

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Result doctorDelete(Integer doctorId) {
        int num = doctorService.deleteDoctor(doctorId);
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

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Result departmentUpdate(@RequestBody Doctor doctor) {
        int num = doctorService.updateDoctor(doctor);
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

    @RequestMapping(value = "find",method = RequestMethod.POST)
    public Result listDoctor() {
        List<Doctor> doctorList = doctorService.doctorList();
        Result result = new Result();
        if (doctorList != null) {
            result.setCode(200);
            result.setMessage("查询成功");
            result.setData(doctorList);
            return result;
        } else {
            result.setCode(500);
            result.setMessage("查询失败");
            return result;
        }
    }
}
