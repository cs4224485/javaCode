package com.harry.spring.config;

import com.harry.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// 使用@PropertySource读取外部配置文件中的key/value保存到运行的环境变量中，加载完外部的配置文件以后，使用${}取出配置文件中的值
//@PropertySource(value={"classpath:/person.properties"})
//@Configuration
//public class MainConfigOfPropertyValues {
//
//    @Bean
//    public Person person() {
//        return new Person();
//    }
//}