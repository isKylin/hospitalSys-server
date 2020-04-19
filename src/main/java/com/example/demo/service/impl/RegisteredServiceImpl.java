package com.example.demo.service.impl;

import com.example.demo.dto.RegisteredDTO;
import com.example.demo.entity.Registered;
import com.example.demo.mapper.RegisteredMapper;
import com.example.demo.service.RegisteredService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author klaus
 * @version 1.0
 * @date 2020/4/18 21:32
 */
@Service
public class RegisteredServiceImpl implements RegisteredService {

    @Resource
    private RegisteredMapper registeredMapper;

    /**
     * 新增挂号信息
     * @param registered 预约挂号信息
     * @return int
     */
    @Override
    public int createRegistered(Registered registered) {
        return registeredMapper.createRegistered(registered);
    }

    /**
     * 修改挂号信息
     * @param registered 预约挂号信息
     * @return int
     */
    @Override
    public int updateRegistered(Registered registered) {
        try {
            if(registered == null || registered.getAppointmentId() < 1 || "".equals(registered.getAppointmentId())){
                return 0;
            }
            System.out.println("success");
            return registeredMapper.updateRegistered(registered);
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 删除挂号信息
     * @param registeredId 挂号编号
     * @return int
     */
    @Override
    public int deleteRegistered(Integer registeredId) {
        if(registeredId < 1){
            return 0;
        }
        return registeredMapper.deleteRegistered(registeredId);
    }

    /**
     * 根据关键字模糊查询挂号信息列表
     * @param keyword  关键字
     * @param pageNum  页面数
     * @param pageSize 每页含有的数据数量
     * @return PageInfo<RegisteredDTO>
     */
    @Override
    public PageInfo<RegisteredDTO> registeredList(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<RegisteredDTO> registeredList;
        if(keyword == null){
            registeredList = registeredMapper.registeredListTwo();
        }else{
            registeredList = registeredMapper.registeredList(keyword);
        }

        System.out.println("keyword:"+keyword);

        PageInfo<RegisteredDTO> pageInfo = new PageInfo<>(registeredList);
        return pageInfo;
    }
}
