package com.harry.spring.mapper;

import com.harry.spring.bean.Department;
import org.apache.ibatis.annotations.*;


public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department selectDepartment(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update from department set name=#{departmentName} where id=#{id} ")
    public void  updateDepartment(Department department);
}
