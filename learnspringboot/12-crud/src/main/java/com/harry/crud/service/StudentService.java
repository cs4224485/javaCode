package com.harry.crud.service;

import com.harry.crud.bean.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAllStudent();
    Student selectStudentById(int id);
}
