package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface PowerService {
    int updatePower(User user);
    List<User> powerList();
}
