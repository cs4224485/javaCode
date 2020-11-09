package com.harry.mybatis.service.Impl;

import com.harry.mybatis.bean.Student;
import com.harry.mybatis.mapper.StudentMapper;
import com.harry.mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectAllStudent() {

        return studentMapper.selectAllStudent();
    }
}
