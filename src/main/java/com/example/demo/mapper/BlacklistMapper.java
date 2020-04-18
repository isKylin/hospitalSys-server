package com.example.demo.mapper;

import com.example.demo.entity.Blacklist;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlacklistMapper {
    // 查询所有黑名单信息
    @Select("select * from blacklist_info")
    List<Blacklist> findAllBlacklist();
    // 添加黑名单
    @Insert("insert into blacklist_info(patient_name,blacklist_reason)" +
            "values(#{patient_name},#{blacklist_reason})")
    void insertBlacklist(Blacklist blacklist);
}
