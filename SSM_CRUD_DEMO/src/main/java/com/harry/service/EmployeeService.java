package com.harry.service;

import com.harry.bean.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    List<Employee> getAll();

    Employee getEmp(Integer id);

    boolean checkUser(String empName);

    void saveEmp(Employee employee);

    void deleteBatch(List<Integer> del_ids);

    void deleteEmp(Integer id);

    void updateEmp(Employee employee);
}
