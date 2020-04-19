package com.example.demo.controller;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.entity.Appointment;
import com.example.demo.entity.Result;
import com.example.demo.service.AppointmentService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author klaus
 * @version 1.0
 * @date 2020/4/18 17:00
 */
@RequestMapping("/appointment")
@RestController
public class AppointmentController {

    @Resource
    private AppointmentService appointmentService;

    /**
     * 新增预约信息
     * @param appointment 预约实体信息
     * @return Result
     */
    @PostMapping(value = "create")
    public Result appointmentCreate(@RequestBody Appointment appointment) {
        
        int num = appointmentService.createAppointment(appointment);
        Result result = new Result();
        if (num > 0) {
            result.setCode(200);
            result.setMessage("插入数据成功");
            return result;
        } else {
            result.setCode(500);
            result.setMessage("插入数据失败");
            return result;
        }
    }

    /**
     * 修改预约信息
     * @param appointment 预约实体信息
     * @return Result
     */
    @PostMapping(value = "/update")
    public Result appointmentUpdate(@RequestBody Appointment appointment) {
        int num = appointmentService.updateAppointment(appointment);
        System.out.println("*****修改的预约信息的id：" + appointment.getAppointmentId());

        Result result = new Result();
        if (num > 0) {
            result.setCode(200);
            result.setMessage("数据修改成功");
            return result;

        } else {
            result.setCode(500);
            result.setMessage("数据修改失败");
            return result;
        }
    }

    /**
     * 删除预约信息
     * @param appointmentId 预约实体编号
     * @return Result
     */
    @PostMapping(value = "/delete")
    public Result delete(Integer appointmentId)
    {
        int num = appointmentService.deleteAppointment(appointmentId);
        System.out.println("*****删除的预约信息ID："+ num);
        Result result=new Result();
        if(num > 0)
        {
            result.setCode(200);
            result.setMessage("数据删除成功");
            return result;
        }else{
            result.setCode(500);
            result.setMessage("数据删除失败");
            return result;
        }
    }

    /**
     * 根据关键字查询获得预约信息集合
     * @param keyword 关键字
     * @param pageNum 页面数
     * @param pageSize 每页含有的数据数量
     * @return Result
     */
    @ResponseBody
    @PostMapping(value = "/appointmentList")
    public Result appointmentList(@RequestParam(value = "keyword", required = false) String keyword,
                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

        PageInfo<AppointmentDTO> pageInfo =appointmentService.appointmentList(keyword, pageNum, pageSize);
        Result result = new Result();
        if(pageInfo != null){
            result.setCode(200);
            result.setMessage("数据查询成功");
            result.setData(pageInfo);
            return result;
        }else{
            result.setCode(500);
            result.setMessage("数据查询失败");
            return result;
        }
    }
}