package com.example.demo.controller;

import com.example.demo.entity.Duty;
import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.service.DutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("duty")
@RestController
public class DutyController {
    @Resource
    private DutyService dutyService;

    @RequestMapping(value = "find",method = RequestMethod.GET)
    public Result listDuty() {
        List<Duty> dutyList = dutyService.findAllDuty();
        Result result = new Result();
        if (dutyList != null) {
            result.setCode(200);
            result.setMessage("查询成功");
            return result;
        } else {
            result.setCode(500);
            result.setMessage("查询失败");
            return result;
        }
    }
}
