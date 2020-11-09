package com.harry.dao.Impl;

import com.harry.bean.Student;
import com.harry.util.MyBatisUtil;
import com.harry.dao.StudentDao;

import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class StudentDaoImpl implements StudentDao {
    private SqlSession sqlSession;

    @Override
    public void insertStudent(Student student) {
        try {
            //创建SqlSession对象
            sqlSession = MyBatisUtil.getSqlSession();
            //新增数据操作
            sqlSession.insert("insertStudent", student);
            //提交SqlSession
            sqlSession.commit();
        } finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }

    @Override
    public void deleteStudent(int id) {
        try {
            SqlSession sqlSession = MyBatisUtil.getSqlSession();
            sqlSession.delete("deleteStudent", id);
            sqlSession.commit();
        }finally {
    if (sqlSession != null){
        sqlSession.close();
            }
        }
    }

    @Override
    public void updateStudent(Student student) {
        try {
            //创建SqlSession对象
            sqlSession = MyBatisUtil.getSqlSession();
            //新增数据操作
            sqlSession.update("updateStudent", student);
            //提交SqlSession
            sqlSession.commit();
        } finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }

    @Override
    public List<Student> selectAllStudent() {
        try {
            List<Student> result = null;
            SqlSession sqlSession = MyBatisUtil.getSqlSession();
            result = sqlSession.selectList("selectAllStudent");
            return result;
        }finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }

    @Override
    public Student selectStudentById(int id) {
        Student student = null;
        try{
            SqlSession sqlSession = MyBatisUtil.getSqlSession();
            student = sqlSession.selectOne("selectStudentById", id);
            return student;
        }finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }

    @Override
    public Student selectStudentByName(String name) {
        Student student = null;
        try{
            SqlSession sqlSession = MyBatisUtil.getSqlSession();
            student = sqlSession.selectOne("selectStudentByName", name);
            return student;
        }finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }

    @Override
    public Student selectStudentByPwd(int id) {
        Student student = null;
        try{
            SqlSession sqlSession = MyBatisUtil.getSqlSession();
            student = sqlSession.selectOne("selectStudentByPwd", id);
            return student;
        }finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
