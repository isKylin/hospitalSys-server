package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    // 用户登陆
    @Select("select * from user_info where user_name = #{user_name} and user_password = #{user_password}")
    User userLogin(User user);

    // 用户注册
    @Insert("insert into user_info(user_name,user_password,user_role) values (#{user_name},#{user_password},'1')")
    int userRegister(User user);

    // 修改密码
    @Update("update user_info set user_password = #{user_password} where user_name = #{user_name}")
    void userUpdatePwd(User user);
}
