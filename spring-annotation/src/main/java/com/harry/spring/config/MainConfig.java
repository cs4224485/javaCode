package com.harry.spring.config;

import com.harry.spring.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration // 告诉Spring这是一个配置类
//@ComponentScan(value="com.harry.spring", excludeFilters={
//        /*
//         * type：指定你要排除的规则，是按照注解进行排除，还是按照给定的类型进行排除，还是按照正则表达式进行排除，等等
//         * classes：除了@Controller和@Service标注的组件之外，IOC容器中剩下的组件我都要，即相当于是我要排除@Controller和@Service这俩注解标注的组件。
//         */
//        @ComponentScan.Filter(type= FilterType.ANNOTATION, classes={Controller.class, Service.class})
//}) // value指定要扫描的包
@ComponentScan(value="com.harry.spring", includeFilters={
        /*
         * type：指定你要排除的规则，是按照注解进行排除，还是按照给定的类型进行排除，还是按照正则表达式进行排除，等等
         * classes：我们需要Spring在扫描时，只包含@Controller注解标注的类
         */
        @ComponentScan.Filter(type=FilterType.ANNOTATION, classes={Controller.class})
}, useDefaultFilters=false) // value指定要扫描的包
public class MainConfig {
    //@Bean注解是给IOC容器中注册一个bean，类型就是返回值类型，id默认用方法名
    @Bean
    public Person person(){
        return new Person("cs",18);
    }
}
