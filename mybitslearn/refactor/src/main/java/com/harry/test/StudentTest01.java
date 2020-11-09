package com.harry.test;


import com.harry.bean.Student;
import com.harry.dao.Impl.StudentDaoImpl;
import com.harry.dao.StudentDao;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StudentTest01 {

    private StudentDao studentDao;

    @Before
    public void initStudentDao(){
        studentDao = new StudentDaoImpl();
    }
    @Test
    public void insertStudent(){
        Student student = new Student("harry2", 52, 98.50);
        studentDao.insertStudent(student);
    }

    @Test
    public void deleteStudent(){
        // 删除id是2的数据
        studentDao.deleteStudent(7);
    }
    @Test
    public void updateStudent(){
        Student student = new Student("蔡爽", 25, 100);
        student.setId(5);
        studentDao.updateStudent(student);
    }

    @Test
    public void selectAllStudent(){
        List<Student> students = studentDao.selectAllStudent();
        students.forEach((student -> {
            System.out.println(student);
        }));
    }
    @Test
    public void selectStudentById(){
        Student student = studentDao.selectStudentById(5);
        System.out.println(student);
    }

    @Test
    public void selectStudentByName(){
        Student student = studentDao.selectStudentByName("rry");
        System.out.println(student);
    }

    @Test
    public void selectStudentByPwd(){
        Student student = studentDao.selectStudentByPwd(5);
        System.out.println(student);
    }
}