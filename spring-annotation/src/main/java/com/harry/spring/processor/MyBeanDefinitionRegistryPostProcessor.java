package com.harry.spring.processor;

import com.harry.spring.bean.Blue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("MyBeanDefinitionRegistryPostProcessor...bean的数量：" + beanFactory.getBeanDefinitionCount());
    }

    /**
     * 这个BeanDefinitionRegistry就是Bean定义信息的保存中心，这个注册中心里面存储了所有的bean定义信息，
     * 以后，BeanFactory就是按照BeanDefinitionRegistry里面保存的每一个bean定义信息来创建bean实例的。
     *
     * bean定义信息包括有哪些呢？有这些，这个bean是单例的还是多例的、bean的类型是什么以及bean的id是什么。
     * 也就是说，这些信息都是存在BeanDefinitionRegistry里面的。
     */

    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("postProcessBeanDefinitionRegistry...bean的数量：" + registry.getBeanDefinitionCount());
        // 除了查看bean的数量之外，我们还可以给容器里面注册一些bean，我们以前也简单地用过
        /*
         * 第一个参数：我们将要给容器中注册的bean的名字
         * 第二个参数：BeanDefinition对象
         */
        // RootBeanDefinition beanDefinition = new RootBeanDefinition(Blue.class); // 现在我准备给容器中添加一个Blue对象
        // 咱们也可以用另外一种办法，即使用BeanDefinitionBuilder这个构建器生成一个BeanDefinition对象，很显然，这两种方法的效果都是一样的
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Blue.class).getBeanDefinition();
        registry.registerBeanDefinition("hello", beanDefinition);
    }

}
