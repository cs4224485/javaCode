package com.harry.service.imlp;

import com.harry.service.StudentService;

public class StudentServiceImpl implements StudentService {

    public void study() {
        System.out.println("好好学习，天天向上");
    }

    public StudentServiceImpl() {
        System.out.println("studentService的构造方法执行");
    }
    public void init(){
        System.out.println("初始化方法");
    }
    public void destroy(){
        System.out.println("销毁方法");
    }
}
