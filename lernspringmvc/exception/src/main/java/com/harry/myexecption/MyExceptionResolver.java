package com.harry.myexecption;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理器
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    /**
     * 只要程序中有异常抛出,那么就会执行该方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("ex", e);
        mv.setViewName("error/error");
        // 判断异常对象是否是MyExecption对象
        if(e instanceof MyException){
            // 记录日志
            // 设置跳转页面
            mv.setViewName("error/myerror");
        }else if(e instanceof NullPointerException){
            // 记录日志
            //...
        }
        return mv;
    }
}
