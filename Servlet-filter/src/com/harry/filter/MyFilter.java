package com.harry.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    public  MyFilter(){
        System.out.println("实例化");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤请求");
        // 通过过滤器继续访问资源
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("过滤响应");
    }
}
