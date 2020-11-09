package com.harry.factory;

import com.harry.service.StudentService;
import com.harry.service.imlp.StudentServiceImpl;

public class MyBeanStaticFactory {
    public static StudentService createStudentService(){
        return new StudentServiceImpl();
    }
}
