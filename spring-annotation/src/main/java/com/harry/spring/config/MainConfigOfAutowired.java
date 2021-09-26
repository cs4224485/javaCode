package com.harry.spring.config;

import com.harry.spring.bean.Car;
import com.harry.spring.bean.Color;
import com.harry.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.harry.spring.service", "com.harry.spring.dao", "com.harry.spring.controller", "com.harry.spring.bean"})
public class MainConfigOfAutowired {
    @Qualifier("bookDao")
    @Autowired(required=false)
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return bookDao;
    }

//    @Bean
//    public Color color(Car car) {
//        Color color = new Color();
//        color.setCar(car);
//        return color;
//    }

    @Bean
    public Color color(@Autowired Car car) {
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
