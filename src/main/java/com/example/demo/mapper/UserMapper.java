package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    /**
     * 用户登录
     * @param userName 用户名称
     * @param userPassword 用户密码
     * @return UserDTO
     */
    UserDTO userLogin(@Param("userName")String userName, @Param("userPassword")String userPassword);
    @Select("select u.user_id, u.user_name, r.role_name from user_info u left join role_info r " +
            "on u.user_role = r.role_id " +
            "where u.user_name =#{userName} and u.user_password = #{userPassword}")

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
