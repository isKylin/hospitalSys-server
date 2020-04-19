package com.example.demo.mapper;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    /**
     * 新增部门信息
     * @param department 部门实体信息
     * @return int
     */
    @Insert("insert into department_info(department_name,department_content) " +
            "values (#{departmentName},#{departmentContent})")
    int createDepartment(Department department);

    /**
     * 删除部门信息
     * @param departmentId 部门编号
     * @return int
     */
    @Delete("delete from department_info where department_id = #{departmentId};")
    int deleteDepartment(@Param("departmentId") Integer departmentId);

    /**
     * 修改部门信息
     * @param department 部门实体信息
     * @return int
     */
    @Update("update department_info set department_name = #{departmentName}," +
            "department_content = #{departmentContent} where department_id = #{departmentId}")
    int updateDepartment(Department department);

    /**
     * 查询所有信息
     * @return List<Department>
     */
    @Select("select * from department_info")
    List<Department> departmentList();
}
