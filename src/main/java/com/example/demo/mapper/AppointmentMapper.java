package com.example.demo.mapper;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.entity.Appointment;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author klaus
 * @version 1.0
 * @date 2020/4/17 21:50
 */
@Mapper
public interface AppointmentMapper {

    /**
     * 新增预约信息
     * @param appointment 预约实体信息
     * @return int
     */
    @Insert("insert into appointment_info(department_id,doctor_id,appointment_count,appointment_registered_count,appointment_date) " +
            "values (#{departmentId},#{doctorId},#{appointmentCount},0,CURDATE())")
    int createAppointment(Appointment appointment);

    /**
     * 修改预约信息
     * @param appointment 预约实体信息
     * @return int
     */
    @Update("update appointment_info set department_id = #{departmentId}," +
            "doctor_id = #{doctorId}, appointment_count = #{appointmentCount}, " +
            "appointment_date = #{appointmentDate} where appointment_id = #{appointmentId}")
    int updateAppointment(Appointment appointment);

    /**
     * 修改已预约人数
     * @param appointmentRegisteredCount 已预约人数
     * @param appointmentId 预约ID
     * @return int
     */
    @Update("update appointment_info set appointment_registered_count = #{appointmentRegisteredCount} " +
            "where appointment_id = #{appointmentId}")
    int updateAppointmentRegisteredCount(@Param("appointmentRegisteredCount") Integer appointmentRegisteredCount,
                                         @Param("appointmentId") Integer appointmentId);

    /**
     * 删除预约信息
     * @param appointmentId 预约编号
     * @return int
     */
    @Delete("delete from appointment_info where appointment_id = #{appointmentId};")
    int deleteAppointment(@Param("appointmentId") Integer appointmentId);

    /**
     * 根据关键字模糊查询预约信息列表
     * @param keyword 关键字
     * @return List<Appointment>
     */
    @Select("select a.appointment_id, a.department_id, d.department_name, a.doctor_id, o.doctor_name, " +
            "a.appointment_count, a.appointment_registered_count, a.appointment_date " +
            "from appointment_info a " +
            "left join department_info d on a.department_id = d.department_id " +
            "left join doctor_info o on a.doctor_id = o.doctor_id " +
            "where o.doctor_name LIKE CONCAT('%',#{keyword},'%')")
    List<AppointmentDTO> appointmentList(@Param("keyword") String keyword);

    /**
     * 查询预约信息列表
     * @return List<AppointmentDTO>
     */
    @Select("select a.appointment_id, a.department_id, d.department_name, a.doctor_id, o.doctor_name, " +
            "a.appointment_count, a.appointment_registered_count, a.appointment_date " +
            "from appointment_info a " +
            "left join department_info d on a.department_id = d.department_id " +
            "left join doctor_info o on a.doctor_id = o.doctor_id")
    List<AppointmentDTO> appointmentListTwo();

}
