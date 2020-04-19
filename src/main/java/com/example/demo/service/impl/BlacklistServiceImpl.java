package com.example.demo.service.impl;

import com.example.demo.entity.Blacklist;
import com.example.demo.entity.Doctor;
import com.example.demo.mapper.BlacklistMapper;
import com.example.demo.service.BlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BlacklistServiceImpl implements BlacklistService {
    @Resource
    private BlacklistMapper blacklistMapper;

    @Override
    public int createBlacklist(Blacklist blacklist){
        return blacklistMapper.createBlacklist(blacklist);
    }

    @Override
    public List<Blacklist> blacklistList(){
        return blacklistMapper.blacklistList();
    }
}
