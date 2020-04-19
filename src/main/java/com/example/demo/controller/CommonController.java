package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("common")
@RestController
public class CommonController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public Result registerUser(@RequestBody User user) {
        int num = userService.userRegister(user);
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

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Result pwdUpdate(@RequestBody User user) {
        int num = userService.userUpdatePwd(user);
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
}
