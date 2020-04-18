package com.example.demo.service.impl;

import com.example.demo.entity.Blacklist;
import com.example.demo.mapper.BlacklistMapper;
import com.example.demo.service.BlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlacklistServiceImpl implements BlacklistService {
    @Autowired
    private BlacklistMapper blacklistMapper;

    @Override
    public List<Blacklist> findAllBlacklist(){
        return blacklistMapper.findAllBlacklist();
    }

    @Override
    public void insertBlacklist(Blacklist blacklist){
        blacklistMapper.insertBlacklist(blacklist);
    }
}
