package com.harry.test;

import com.harry.bean.Employee;
import com.harry.dao.EmployeeDao;
import com.harry.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class EmployeeTest {
    private EmployeeDao employeeDao;
    private SqlSession sqlSession;

    @Before
    public void initTeamDao() {
        sqlSession = MyBatisUtil.getSqlSession();
        employeeDao = sqlSession.getMapper(EmployeeDao.class);
    }

    @After
    public void closeSession() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
    @Test
    public void selectChildrenByPid(){
        List<Employee> employees = employeeDao.selectChildrenByPid(1002);
        employees.forEach(employee -> {
            System.out.println(employee);
        });
    }

    @Test
    public void selectEmployeeByPid(){
        List<Employee> employees = employeeDao.selectEmployeeByPid(1002);
        employees.forEach(employee -> {
            System.out.println(employee);
        });
    }
}
