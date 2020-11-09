package com.harry.test;

import com.harry.bean.Course;
import com.harry.dao.CourseDao;
import com.harry.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseTest {
    private CourseDao courseDao;
    private SqlSession sqlSession;

    @Before
    public void initTeamDao() {
        sqlSession = MyBatisUtil.getSqlSession();
        courseDao = sqlSession.getMapper(CourseDao.class);
    }

    @After
    public void closeSession() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
    @Test
    public void selectCourseStuden(){
        Course course = courseDao.selectCourseStudent(1001);
        System.out.println(course);
    }
}
