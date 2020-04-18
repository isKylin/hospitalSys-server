package com.example.demo.service.impl;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.entity.Appointment;
import com.example.demo.mapper.AppointmentMapper;
import com.example.demo.service.AppointmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author klaus
 * @version 1.0
 * @date 2020/4/18 16:45
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Resource
    private AppointmentMapper appointmentMapper;

    /**
     * 新增预约信息
     * @param appointment 预约实体信息
     * @return int
     */
    @Override
    public int createAppointment(Appointment appointment) {
        return appointmentMapper.createAppointment(appointment);
    }

    /**
     * 修改预约信息
     * @param appointment 预约实体信息
     * @return int
     */
    @Override
    public int updateAppointment(Appointment appointment) {
        try {
            if(appointment == null || appointment.getAppointmentId() < 1 || "".equals(appointment.getAppointmentId())){
                return 0;
            }
            System.out.println("success");
            return appointmentMapper.updateAppointment(appointment);
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 删除预约信息
     * @param appointmentId 预约编号
     * @return int
     */
    @Override
    public int deleteAppointment(Integer appointmentId) {
        if(appointmentId < 1){
            return 0;
        }
        return appointmentMapper.deleteAppointment(appointmentId);
    }

    /**
     * 根据关键字模糊查询预约信息列表
     * @param keyword  关键字
     * @param pageNum  页面数
     * @param pageSize 每页含有的数据数量
     * @return PageInfo<Appointment>
     */
    @Override
    public PageInfo<AppointmentDTO> appointmentList(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AppointmentDTO> appointmentList;
        if(keyword == null){
            appointmentList = appointmentMapper.appointmentListTwo();
        }else{
            appointmentList = appointmentMapper.appointmentList(keyword);
        }

        System.out.println("keyword:"+keyword);

        PageInfo<AppointmentDTO> pageInfo = new PageInfo<>(appointmentList);
        return pageInfo;
    }
}
