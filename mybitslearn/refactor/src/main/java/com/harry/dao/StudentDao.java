package com.harry.dao;


import com.harry.bean.Student;

import java.util.List;

public interface StudentDao {
    void insertStudent(Student student);
    void deleteStudent(int id);
    void updateStudent(Student student);
    List<Student> selectAllStudent();
    Student selectStudentById(int id);
    Student selectStudentByName(String name);
    Student selectStudentByPwd(int id);
}
