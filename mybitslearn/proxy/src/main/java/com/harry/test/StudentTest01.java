package com.harry.test;


import com.harry.bean.Student;

import com.harry.dao.StudentDao;
import com.harry.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StudentTest01 {

    private StudentDao studentDao;
    private SqlSession sqlSession;

    @Before
    public void initStudentDao(){
        sqlSession = MyBatisUtil.getSqlSession();
        // 获取student Dao的对象
        studentDao = sqlSession.getMapper(StudentDao.class);
    }
    @Test
    public void insertStudent(){
        Student student = new Student("harry2", 52, 98.50);
        studentDao.insertStudent(student);
    }

    @After
    public void closeSession(){
        if(sqlSession != null){
            sqlSession.close();
        }
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