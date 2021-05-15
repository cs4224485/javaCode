package com.harry.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.harry.springcloud.dao")
public class MyBatisConfig {
}
