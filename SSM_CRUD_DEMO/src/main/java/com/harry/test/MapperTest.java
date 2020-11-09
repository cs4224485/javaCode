package com.harry.test;

import com.harry.bean.Department;
import com.harry.bean.Employee;
import com.harry.crud.dao.DepartmentMapper;
import com.harry.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * 测试dao层的工作
 * @author lfy
 *推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 *1、导入SpringTest模块
 *2、@ContextConfiguration指定Spring配置文件的位置
 *3、直接autowired要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;


    @Test
    public void testCrud(){
        //1、插入几个部门
//        System.out.println(departmentMapper);
//		departmentMapper.insertSelective(new Department(1, "开发部"));
//		departmentMapper.insertSelective(new Department(2, "测试部"));
        //2、生成员工数据，测试员工插入
        employeeMapper.insertSelective(new Employee(22222, "Jerry", "erry@atguigu.com", "M", 1));
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for(int i = 0;i<1000;i++){
            String uid = UUID.randomUUID().toString().substring(0,5)+i;
            mapper.insertSelective(new Employee(i, uid, uid+"@qq.com", "M",1));
        }
        System.out.println("批量完成");

    }
}
