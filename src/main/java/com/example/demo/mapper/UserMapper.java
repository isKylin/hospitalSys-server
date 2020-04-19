package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    /**
     * 用户注册信息
     * @param user 用户实体信息
     * @return int
     */
    @Insert("insert into user_info(user_name,user_password,user_role) values (#{userName},#{userPassword},'1')")
    int userRegister(User user);

    /**
     * 用户修改密码
     * @param user 用户实体信息
     * @return int
     */
    @Update("update user_info set user_password = #{userPassword} where user_id = #{userId}")
    int userUpdatePwd(User user);

}
