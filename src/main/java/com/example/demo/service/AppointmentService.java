package com.example.demo.service;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.entity.Appointment;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author klaus
 * @version 1.0
 * @date 2020/4/18 16:45
 */
public interface AppointmentService {

    /**
     * 新增预约信息
     * @param appointment 预约实体信息
     * @return int
     */
    int createAppointment(Appointment appointment);

    /**
     * 修改预约信息
     * @param appointment 预约实体信息
     * @return int
     */
    int updateAppointment(Appointment appointment);

    /**
     * 删除预约信息
     * @param appointmentId 预约编号
     * @return int
     */
    int deleteAppointment(@Param("appointmentId") Integer appointmentId);



    /**
     * 根据关键字模糊查询预约信息列表
     * @param keyword 关键字
     * @param pageNum 页面数
     * @param pageSize 每页含有的数据数量
     * @return PageInfo<AppointmentDTO>
     */
    PageInfo<AppointmentDTO> appointmentList(String keyword, Integer pageNum, Integer pageSize);
}
