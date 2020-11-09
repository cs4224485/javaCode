package com.harry.dao;

import com.harry.bean.Employee;

import java.util.List;

public interface EmployeeDao {
   List<Employee> selectChildrenByPid(int mgr);
   List<Employee> selectEmployeeByPid(int id);
}
