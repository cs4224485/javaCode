package com.harry.test;


import com.harry.bean.Student;
import com.harry.dao.StudentDao;
import com.harry.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentTest01 {

    private StudentDao studentDao;
    private SqlSession sqlSession;

    @Before
    public void initStudentDao() {
        sqlSession = MyBatisUtil.getSqlSession();
        studentDao = sqlSession.getMapper(StudentDao.class);
    }

    @After
    public void closeSession() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void selectIf() {
        Student student = new Student("harry", 58, 0.0);
        List<Student> students = studentDao.selectIf(student);
        students.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    public void selectChoose() {
        Student student = new Student("harry", 30, 0.0);
        List<Student> students = studentDao.selectChoose(student);
        students.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    public void selectForeachArray() {
        int[] ids = {1, 3, 5, 7};
        List<Student> students = studentDao.selectForeachArray(ids);
        students.forEach(student -> {
            System.out.println(student);
        });
    }
    @Test
    public void selectForeachList(){
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(3);
        ids.add(5);
        List<Student> students = studentDao.selectForeachList(ids);
        students.forEach(student -> {
            System.out.println(student);
        });
    }
    @Test
    public void selectForeachListStudent(){
        List<Student> stuList = new ArrayList<>();
        Student s1 = new Student();
        Student s2 = new Student();
        s1.setId(1);
        s2.setId(5);
        stuList.add(s1);
        stuList.add(s2);
        List<Student> students = studentDao.selectForeachListStudent(stuList);
        students.forEach(student -> {
            System.out.println(student);
        });
    }
}