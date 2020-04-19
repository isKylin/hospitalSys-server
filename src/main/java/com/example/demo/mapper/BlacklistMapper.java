package com.example.demo.mapper;

import com.example.demo.entity.Blacklist;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlacklistMapper {
    /**
     * 新增黑名单信息
     * @param blacklist 黑名单实体信息
     * @return int
     */
    @Insert("insert into blacklist_info(patient_name,blacklist_reason)" +
            "values(#{patientName},#{blacklistReason})")
    int createBlacklist(Blacklist blacklist);

    /**
     * 查询所有信息
     * @return List<Doctor>
     */
    @Select("select * from doctor_info")
    List<Blacklist> blacklistList();
}
