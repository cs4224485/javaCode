package com.harry.mybatis.mapper;

import com.harry.mybatis.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface StudentMapper {
    List<Student> selectAllStudent();
}
