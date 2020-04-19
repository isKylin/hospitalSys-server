package com.example.demo.controller;

import com.example.demo.VO.RegisteredVO;
import com.example.demo.dto.RegisteredDTO;
import com.example.demo.entity.Registered;
import com.example.demo.entity.Result;
import com.example.demo.mapper.AppointmentMapper;
import com.example.demo.mapper.RegisteredMapper;
import com.example.demo.service.RegisteredService;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.demo.util.DateUtil.compairWithDate;
import static com.example.demo.util.DateUtil.parshDateFormat;
import static com.example.demo.util.DateUtil.parshDateTimeFormat;

/**
 * @author klaus
 * @version 1.0
 * @date 2020/4/18 21:39
 */
@RequestMapping("/registered")
@RestController
public class RegisteredController {

    @Resource
    private RegisteredService registeredService;

    @Resource
    private RegisteredMapper registeredMapper;

    @Resource
    private AppointmentMapper appointmentMapper;

    /**
     * 新增挂号信息
     * @param registeredVO 挂号实体信息
     * @return Result
     */
    @Transactional
    @PostMapping(value = "create")
    public Result registeredCreate(@RequestBody RegisteredVO registeredVO) {
        long three = 1000*60*24*60;
        long one = compairWithDate(registeredVO.getRegisteredDate(),registeredVO.getAppointmentDate())/three;
        long two = compairWithDate(registeredVO.getAppointmentDate(),registeredVO.getRegisteredDate())/three;
        Result result = new Result();
        System.out.println(one);
        System.out.println(two);
        if(one>=0){
            registeredVO.setRegisteredStatus("截止");
            if(registeredService.createRegistered(registeredVO)>0) {
                result.setCode(401);
                result.setMessage("预约时间已截止");
            }
            return result;
        }
        if(registeredVO.getAppointmentCount().equals(registeredVO.getAppointmentRegisteredCount())){
            registeredVO.setRegisteredStatus("约满");
            if(registeredService.createRegistered(registeredVO)>0) {
                result.setCode(402);
                result.setMessage("该预约已满");
            }
            return result;
        }
        if(registeredMapper.getRegisteredCount(registeredVO.getPatientId())>5 ){
            result.setCode(403);
            result.setMessage("个人预约数量已达到上线");
            return result;
        }
        if( two>7 || two<1 ){
            result.setCode(404);
            result.setMessage("预约时间至少提前一天，至多提前一周");
            return result;
        } else {
            if (registeredService.createRegistered(registeredVO) > 0) {
                appointmentMapper.updateAppointmentRegisteredCount(registeredVO.getAppointmentRegisteredCount()+1,
                        registeredVO.getAppointmentId());
                result.setCode(200);
                result.setMessage("预约成功");

            }
            return result;
        }
    }

    /**
     * 修改挂号信息
     * @param registered 挂号实体信息
     * @return Result
     */
    @PostMapping(value = "/update")
    public Result registeredUpdate(@RequestBody Registered registered) {
        int num = registeredService.updateRegistered(registered);
        System.out.println("*****修改的挂号信息的id：" + registered.getRegisteredId());

        Result result = new Result();
        if (num > 0) {
            result.setCode(200);
            result.setMessage("修改数据成功");
            return result;

        } else {
            result.setCode(500);
            result.setMessage("修改数据失败");
            return result;
        }
    }

    /**
     * 删除挂号信息
     * @param registeredId 挂号实体编号
     * @return Result
     */
    @PostMapping(value = "/delete")
    public Result delete(@RequestParam(value = "registeredId")Integer registeredId)
    {
        Result result=new Result();
        int num = registeredService.deleteRegistered(registeredId);
        if(num > 0)
        {
            result.setCode(200);
            result.setMessage("数据删除成功");
            return result;
        }else{
            result.setCode(500);
            result.setMessage("删除数据失败");
            return result;
        }
    }

    /**
     * 取消挂号信息
     * @param registeredId 挂号实体编号
     * @return Result
     */
    @Transactional
    @PostMapping(value = "/cancel")
    public Result cancel(@RequestParam(value = "registeredId")Integer registeredId,
                         @RequestParam(value = "appointmentRegisteredCount")Integer appointmentRegisteredCount,
                         @RequestParam(value = "appointmentId")Integer appointmentId,
                         @RequestParam(value = "appointmentDate")String appointmentDate)
    {

        Result result=new Result();
        Date date = new Date();
        long three = 1000*60*24*60;
        System.out.println("*****************"+parshDateFormat(appointmentDate));
        long one = compairWithDate(date,parshDateFormat(appointmentDate))/three;
        System.out.println(one);
        if(one>=0){
            result.setCode(500);
            result.setMessage("取消挂号失败");
            return result;
        }
        int num = registeredService.deleteRegistered(registeredId);
        if(num > 0)
        {
            appointmentMapper.updateAppointmentRegisteredCount(appointmentRegisteredCount-1,
                    appointmentId);
            result.setCode(200);
            result.setMessage("取消挂号成功");
            return result;
        }else{
            result.setCode(500);
            result.setMessage("取消挂号失败");
            return result;
        }
    }

    /**
     * 根据关键字查询获得挂号信息集合
     * @param keyword 关键字
     * @param pageNum 页面数
     * @param pageSize 每页含有的数据数量
     * @return Result
     */
    @ResponseBody
    @PostMapping(value = "/registeredList")
    public Result registeredList(@RequestParam(value = "keyword", required = false) String keyword,
                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

        PageInfo<RegisteredDTO> pageInfo =registeredService.registeredList(keyword, pageNum, pageSize);
        Result result = new Result();
        if(pageInfo != null){
            result.setCode(200);
            result.setMessage("查询数据成功");
            result.setData(pageInfo);
            return result;
        }else{
            result.setCode(500);
            result.setMessage("查询数据失败");
            return result;
        }
    }
}
