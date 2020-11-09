package com.harry.crud.mapper;
import com.harry.crud.bean.Student;
import java.util.List;

public interface StudentMapper {
    List<Student> selectAllStudent();
    Student selectStudentById(int id);
}
