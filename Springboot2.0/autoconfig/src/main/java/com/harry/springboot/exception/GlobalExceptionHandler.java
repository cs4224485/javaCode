package com.harry.springboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@Slf4j
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
//    public String handleException(Exception e){
//        log.error("异常是：{}", e);
//        // 试图地址
//        return "login";
//    }
//}
