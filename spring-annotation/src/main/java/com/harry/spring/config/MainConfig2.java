package com.harry.spring.config;

import com.harry.spring.bean.Color;
import com.harry.spring.bean.ColorFactoryBean;
import com.harry.spring.bean.Person;
import com.harry.spring.bean.Red;
import com.harry.spring.selector.MyImportBeanDefinitionRegistrar;
import com.harry.spring.selector.MyImportSelector;
import org.springframework.context.annotation.*;

@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class}) // 满足当前条件，这个类中配置的所有bean注册才能生效
public class MainConfig2  {
    @Bean("Person2")
    @Lazy
    public Person person(){
        System.out.println("给容器中添加咱们这个Person对象...");
        return new Person("harry", 25);
    }
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
