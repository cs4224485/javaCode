package com.harry.springboot.config;

import com.harry.springboot.bean.Car;
import com.harry.springboot.bean.Pet;
import com.harry.springboot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration(proxyBeanMethods = true)
@ConditionalOnMissingBean(name = "tom")
@EnableConfigurationProperties()
public class Myconfig {
    /**
     * Full:外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @return
     */
    @Bean //给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan", 18);
        //user组件依赖了Pet组件
       zhangsan.setPets(Arrays.asList(new Pet(123, "ss")));
        return zhangsan;
    }

    @Bean("tom")
    public Pet tomcatPet(){
        return new Pet(1,"tomcat");
    }

    @Bean("car")
    public Car mycar(){
        return new Car();
    }

}
