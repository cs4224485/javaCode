package com.harry.mybatis.service;

import com.harry.mybatis.bean.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAllStudent();
}
