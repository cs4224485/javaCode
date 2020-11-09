package com.harry.crud.service.Imlp;

import com.harry.crud.bean.Student;
import com.harry.crud.mapper.StudentMapper;
import com.harry.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentDao;

    @Override
    public List<Student> selectAllStudent() {
        return studentDao.selectAllStudent();
    }

    @Override
    public Student selectStudentById(int id) {
        return selectStudentById(id);
    }
}
