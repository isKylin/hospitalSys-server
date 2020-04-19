package com.example.demo.service;

import com.example.demo.entity.Blacklist;

import java.util.List;

public interface BlacklistService {
    int createBlacklist(Blacklist blacklist);
    List<Blacklist> blacklistList();
}
