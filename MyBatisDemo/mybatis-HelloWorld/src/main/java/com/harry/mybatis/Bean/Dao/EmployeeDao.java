package com.harry.mybatis.Bean.Dao;


import com.harry.mybatis.Bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {
    List<Employee> selectEmployees();

    Employee selectEmployeeById(int id);

    int insertEmployee(Employee employee);

    int deleteEmployee(@Param("last_name") String lastName, @Param("gender") String gender);

    int updateEmployee(@Param("last_name") String lastName, @Param("update_name") String updateName);

    Employee getEmployeeById(int id);
    Employee getEmpAndDept(int id);
    Employee getEmpByIdStep(Integer id);
}
