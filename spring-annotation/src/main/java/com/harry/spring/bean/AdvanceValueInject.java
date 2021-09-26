package com.harry.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource(value={"classpath:/advance_value_inject.properties"})
public class AdvanceValueInject {

    @Value("${author.name:cs}")
    private String name;

    // SpEL：调用字符串Hello World的concat方法
    @Value("#{'Hello World'.concat('!')}")
    private String helloWorld;

    // SpEL：调用字符串的getBytes方法，然后再调用其length属性
    @Value("#{'Hello World'.bytes.length}")
    private String helloWorldBytes;


    // SpEL：传入一个字符串，根据","切分后插入列表中， #{}和${}配合使用时，注意不能反过来${}在外面，而#{}在里面
    @Value("#{'${server.name}'.split(',')}")
    private List<String> severs;
}