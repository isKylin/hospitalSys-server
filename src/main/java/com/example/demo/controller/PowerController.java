package com.example.demo.controller;

import com.example.demo.entity.Blacklist;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.service.PowerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("power")
@RestController
public class PowerController {
    @Resource
    private PowerService powerService;

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Result powerUpdate(@RequestBody User user) {
        int num = powerService.updatePower(user);
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
    public Result listPower() {
        List<User> userList = powerService.powerList();
        Result result = new Result();
        if (userList != null) {
            result.setCode(200);
            result.setMessage("查询成功");
            result.setData(userList);
            return result;
        } else {
            result.setCode(500);
            result.setMessage("查询失败");
            return result;
        }
    }
}
