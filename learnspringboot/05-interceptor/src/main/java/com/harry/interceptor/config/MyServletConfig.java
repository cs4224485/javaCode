package com.harry.interceptor.config;

import com.harry.interceptor.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServletConfig {
    @Bean
    public ServletRegistrationBean myServletResgistration(){
        ServletRegistrationBean regist = new ServletRegistrationBean(new MyServlet());
        regist.addUrlMappings("/myServlet");
        return regist;
    }
}
