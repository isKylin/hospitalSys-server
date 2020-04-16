package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface PowerService {
    List<User> findAllPower();
    void updateUserPower(User user);
}
