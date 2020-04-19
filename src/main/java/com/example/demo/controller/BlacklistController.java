package com.example.demo.controller;

import com.example.demo.entity.Blacklist;
import com.example.demo.entity.Result;
import com.example.demo.service.BlacklistService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("blacklist")
@RestController
public class BlacklistController {

    @Resource
    private BlacklistService blacklistService;

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public Result blacklistCreate(@RequestBody Blacklist blacklist) {
        int num = blacklistService.createBlacklist(blacklist);
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

    @RequestMapping(value = "find",method = RequestMethod.GET)
    public Result listBlacklist() {
        List<Blacklist> blacklistList = blacklistService.blacklistList();
        Result result = new Result();
        if (blacklistList != null) {
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
