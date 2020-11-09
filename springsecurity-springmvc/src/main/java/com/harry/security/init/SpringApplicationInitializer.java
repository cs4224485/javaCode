package com.harry.security.init;

import com.harry.security.config.ApplicationConfig;
import com.harry.security.config.WebConfig;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { ApplicationConfig.class}; // 指定rootContext的配置类
    }

    //servletContext，相当于加载springmvc.xml
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    //url-mapping
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        super.customizeRegistration(registration);
                 registration.setMultipartConfig(new MultipartConfigElement("/tmp/coreqi/uploads"));//配置对multipart的支持
                 registration.setLoadOnStartup(1);//设置load-on-startup优先级
    }
}
