package com.harry.springboot.config;


import com.harry.springboot.bean.Pet;
import com.harry.springboot.converter.MyHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cs1
 */
@Configuration
public class WebConfig  {

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setMethodParam("_m");
        return hiddenHttpMethodFilter;
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer(){

            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {

                    @Override
                    public Pet convert(String source) {
                        // 啊猫,3
                        if(!StringUtils.isEmpty(source)){
                            Pet pet = new Pet(2,"mimi");
                            String[] split = source.split(",");
                            pet.setName(split[0]);
                            return pet;
                        }
                        return null;
                    }
                });
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/testbeanResolve").setViewName("hello");
            }

            /***
             * 自定义内容协商策略
             */
//            @Override
//            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//                Map<String, MediaType> mediaTypeMap = new HashMap<>();
//                mediaTypeMap.put("json", MediaType.APPLICATION_JSON);
//                mediaTypeMap.put("xml", MediaType.APPLICATION_XML);
//                mediaTypeMap.put("text/html", MediaType.TEXT_HTML);
//                        mediaTypeMap.put("gg", MediaType.parseMediaType("application/x-harry"));
//                // 指定支持解析哪些参数对应的哪些媒体类型
//                ParameterContentNegotiationStrategy strategy = new ParameterContentNegotiationStrategy(mediaTypeMap);
//                configurer.strategies(Arrays.asList(strategy));
//            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new MyHttpMessageConverter());
            }

        };

    }
}
