package com.harry.springboot.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Order(value = Ordered.HIGHEST_PRECEDENCE)
//@Component
//public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {
//    @Override
//    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        try {
//            response.sendError(411, "自定义异常");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
