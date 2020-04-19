package com.example.demo.service;

import com.example.demo.dto.RegisteredDTO;
import com.example.demo.entity.Registered;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author klaus
 * @version 1.0
 * @date 2020/4/18 21:22
 */
public interface RegisteredService {

    /**
     * 新增挂号信息
     * @param registered 预约挂号信息
     * @return int
     */
    int createRegistered(Registered registered);

    /**
     * 修改挂号信息
     * @param registered 预约挂号信息
     * @return int
     */
    int updateRegistered(Registered registered);

    /**
     * 删除挂号信息
     * @param registeredId 挂号编号
     * @return int
     */
    int deleteRegistered(@Param("registeredId") Integer registeredId);



    /**
     * 根据关键字模糊查询挂号信息列表
     * @param keyword 关键字
     * @param pageNum 页面数
     * @param pageSize 每页含有的数据数量
     * @return PageInfo<RegisteredDTO>
     */
    PageInfo<RegisteredDTO> registeredList(String keyword, Integer pageNum, Integer pageSize);
}
