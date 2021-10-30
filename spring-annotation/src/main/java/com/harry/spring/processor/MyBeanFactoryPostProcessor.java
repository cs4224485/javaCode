package com.harry.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor...postProcessBeanFactory..."); // 这个时候我们所有的bean还没被创建
        // 但是我们可以看一下通过Spring给我们传过来的这个beanFactory，我们能拿到什么
        int count = beanFactory.getBeanDefinitionCount(); // 我们能拿到有几个bean定义
        String[] names = beanFactory.getBeanDefinitionNames(); // 除此之外，我们还能拿到每一个bean定义的名字
        System.out.println("当前BeanFactory中有" + count + "个Bean");
        System.out.println(Arrays.asList(names));
    }
}
