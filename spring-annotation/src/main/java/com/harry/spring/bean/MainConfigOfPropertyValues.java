package com.harry.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value={"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {
    @Value("${person.nickName}")
    private String nickName; // 昵称

    @Bean
    public Person person() {
        return new Person();
    }

}
