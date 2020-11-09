package com.harry.interceptor.config;

import com.harry.interceptor.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(new MyInterceptor());
        // 添加拦截请求
        ir.addPathPatterns("/*");
        // 添加不拦截的请求
        ir.excludePathPatterns("/login");
        // 上面的三行代码通过此行代码即可实现同样功能
        // registry.addInterceptor(new MyInterceptor()).addPathPatterns("/*").excludePathPatterns("/login");
    }
}
