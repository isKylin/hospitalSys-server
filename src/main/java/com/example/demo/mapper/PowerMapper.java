package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PowerMapper {
    // 查看所有人权限信息
    List<User> findAllPower();

    // 修改权限
    void updateUserPower(User user);
}
