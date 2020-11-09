package com.harry.test;


import com.harry.bean.Employee;
import com.harry.util.MyBatisUtil;
import com.harry.dao.EmployeeDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    public void selectLeaderByPid(){
        Employee employee = employeeDao.selectLeaderByPid(1005);
        System.out.println(employee);
    }
}
