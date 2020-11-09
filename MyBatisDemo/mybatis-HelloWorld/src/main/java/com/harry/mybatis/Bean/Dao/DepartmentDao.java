package com.harry.mybatis.Bean.Dao;

import com.harry.mybatis.Bean.Department;

public interface DepartmentDao {
    public Department getDeptById(Integer id);

    public Department getDeptByIdPlus(Integer id);

    public Department getDeptByIdStep(Integer id);
}
