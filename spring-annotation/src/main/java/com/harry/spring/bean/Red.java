package com.harry.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class Red implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入的IOC：" + applicationContext);
        this.applicationContext = applicationContext;
    }

    /**
     * 参数name：IOC容器创建当前对象时，为这个对象起的名字
     */
    public void setBeanName(String name) {
        System.out.println("当前bean的名字：" + name);
    }

    /**
     * 参数resolver：IOC容器启动时会自动地将这个String值的解析器传递过来给我们
     */
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String resolveStringValue = resolver.resolveStringValue("你好，${os.name}，我的年龄是#{20*18}");
        System.out.println("解析的字符串：" + resolveStringValue);
    }


}
