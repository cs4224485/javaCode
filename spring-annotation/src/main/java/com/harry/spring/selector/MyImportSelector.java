package com.harry.spring.selector;

import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector{
    // 返回值：就是要导入到容器中的组件的全类名
    // AnnotationMetadata：当前标注@Import注解的类的所有注解信息，也就是说不仅能获取到@Import注解里面的信息，还能获取到其他注解的信息
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        // 方法不要返回null值，否则会报空指针异常
        return new String[]{"com.harry.spring.bean.Yellow", "com.harry.spring.bean.Bule"}; // 可以返回一个空数组
    }
}
