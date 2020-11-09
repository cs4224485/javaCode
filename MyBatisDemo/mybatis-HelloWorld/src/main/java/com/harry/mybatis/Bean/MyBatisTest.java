package com.harry.mybatis.Bean;

import com.harry.mybatis.Bean.Dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public static void main(String[] args) {
        String resource = "mybatis.xml";
        //读取主配置文件
        InputStream stream = null;
        SqlSession sqlSession = null;
        try {
            stream = Resources.getResourceAsStream(resource);
            //创建SqlSessionFactory对象
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
            //创建SqlSession对象
            sqlSession = sessionFactory.openSession();
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = employeeDao.selectEmployeeById(2);
            System.out.println(employee);
            List<Employee> employees = employeeDao.selectEmployees();
            for (int i = 0; i < employees.size(); i++) {
                System.out.println(employees.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }
    @Test
    public void testInsert(){
        String resource = "mybatis.xml";
        InputStream stream = null;
        SqlSession sqlSession = null;
        try {
            stream = Resources.getResourceAsStream(resource);
            //创建SqlSessionFactory对象
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
            //创建SqlSession对象
            sqlSession = sessionFactory.openSession();
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee entity = new Employee("harry1", "414804000@qq.com", "0");
            employeeDao.insertEmployee(entity);
            System.out.println(entity.getId()+":获取插入后的ID");
            employeeDao.deleteEmployee("harry", "0");
            employeeDao.updateEmployee("harry1", "harry");
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testMap(){
        String resource = "mybatis.xml";
        InputStream stream = null;
        SqlSession sqlSession = null;
        try {
            stream = Resources.getResourceAsStream(resource);
            //创建SqlSessionFactory对象
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
            //创建SqlSession对象
            sqlSession = sessionFactory.openSession();
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee employeeById = employeeDao.getEmployeeById(1);
            Employee empAndDept = employeeDao.getEmpAndDept(1);
            Employee empByIdStep = employeeDao.getEmpByIdStep(1);
            System.out.println(empByIdStep);
            System.out.println(empAndDept);
            System.out.println(employeeById);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
