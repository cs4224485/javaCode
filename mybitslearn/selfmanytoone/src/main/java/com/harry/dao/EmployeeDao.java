package com.harry.dao;

import com.harry.bean.Employee;

public interface EmployeeDao {
   Employee selectLeaderByPid(int mgr);
}
