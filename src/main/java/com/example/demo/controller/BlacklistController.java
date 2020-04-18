package com.example.demo.controller;

import com.example.demo.entity.Blacklist;
import com.example.demo.service.BlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("blacklist")
public class BlacklistController {
    @Autowired
    private BlacklistService blacklistService;

    @RequestMapping("findAllBlacklist")
    public List<Blacklist> findAllBlacklist(){
        return blacklistService.findAllBlacklist();
    }

    @RequestMapping("insertBlacklist")
    public void insertBlacklist(Blacklist blacklist){
        blacklistService.insertBlacklist(blacklist);
    }
}
