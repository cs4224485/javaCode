package com.harry.spring.config;

import com.harry.spring.bean.Person;
import com.harry.spring.condition.LinuxCondition;
import com.harry.spring.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class MainConfig3 {

    @Bean("bill")
    @Conditional({WindowsCondition.class})
    public Person person01(){
        return new Person("Bill Gates", 62);
    }
    @Bean("linus")
    @Conditional(LinuxCondition.class)
    public Person person2(){
        return new Person("Linus", 48);
    }
}
