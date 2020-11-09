package com.harry.mybatis.bean;

import lombok.Data;

@Data // 使用lombok帮我们生成相应的set、get等方法
public class Student {
    private int id;

    private String name;

    private Double score;

    private int age;


}
