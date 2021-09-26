package com.harry.spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个Spring定义的FactoryBean
 * T（泛型）：指定我们要创建什么类型的对象
 * @author liayun
 *
 */
public class ColorFactoryBean implements FactoryBean<Color> {

    // 返回一个Color对象，这个对象会添加到容器中
    public Color getObject() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("ColorFactoryBean...getObject...");
        return new Color();
    }

    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        return Color.class; // 返回这个对象的类型
    }

    // 是单例吗？
    // 如果返回true，那么代表这个bean是单实例，在容器中只会保存一份；
    // 如果返回false，那么代表这个bean是多实例，每次获取都会创建一个新的bean
    public boolean isSingleton() {
        // TODO Auto-generated method stub
        return false;
    }

}
