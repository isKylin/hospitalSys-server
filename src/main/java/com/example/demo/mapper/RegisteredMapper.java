package com.example.demo.mapper;

import com.example.demo.entity.Registered;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author klaus
 * @version 1.0
 * @date 2020/4/18 18:38
 */
@Mapper
public interface RegisteredMapper {
    /**
     * 新增挂号信息
     * @param registered 挂号实体信息
     * @return int
     */
    @Insert("insert into registered_info(registered_status,registered_pay,appointment_id,patient_id,registered_date) " +
            "values (#{registeredStatus},#{registeredPay},#{appointmentId},#{patientId},#{registeredDate}")
    int createRegistered(Registered registered);


    /**
     * 删除挂号信息
     * @param registeredId 预约编号
     * @return int
     */
    @Delete("delete from registered_info where registered_id = #{registeredId};")
    int deleteRegistered(@Param("registeredId") Integer registeredId);

    /**
     * 根据关键字模糊查询挂号信息列表
     * @param keyword 关键字
     * @return List<Registered>
     */
    @Select("select a.department_id, d.department_name, a.doctor_id, o.doctor_name," +
            "a.appointment_count, a.appointment_registered_count, a.appointment_data" +
            "r.registered_status, r.registered_pay, r.registered_date from registered_info r" +
            "left join appointment_info a on r.appointment_id = a.appointment_id" +
            "left join department_info d on a.department_id = d.department_id" +
            "left join doctor_info o on a.doctor_id = o.doctor_id" +
            "left join appointment_info where o.doctor_name LIKE CONCAT('%',#{keyword},'%')")
    List<Registered> registeredList(@Param("keyword") String keyword);
}
