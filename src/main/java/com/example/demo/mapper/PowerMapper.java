package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PowerMapper {

    /**
     * 修改用户权限
     * @param user 用户实体信息
     * @return int
     */
    @Update("update user_info set user_role = #{userRole}")
    int updatePower(User user);

    /**
     * 查询所有权限
     * @return List<User>
     */
    @Select("select * from user_info")
    List<User> powerList();
}
