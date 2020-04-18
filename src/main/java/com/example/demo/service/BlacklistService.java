package com.example.demo.service;

import com.example.demo.entity.Blacklist;

import java.util.List;

public interface BlacklistService {
    List<Blacklist> findAllBlacklist();
    void insertBlacklist(Blacklist blacklist);
}
