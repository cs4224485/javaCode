package com.harry.factory;

import com.harry.service.StudentService;
import com.harry.service.imlp.StudentServiceImpl;

/**
 * 实例工厂
 */
public class MyBeanFactory {
    public StudentService createStudentService(){
        return new StudentServiceImpl();
    }
}
