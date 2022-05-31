package com.harry.spring.aspcet;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    // 如果切入点表达式都一样的情况下，那么我们可以抽取出一个公共的切入点表达式

    @Pointcut("execution(public int com.harry.spring.service.CalcServiceImpl.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void  beforeNotify(){
        System.out.println("********@Before我是前置通知");
    }

    @After("pointCut()")
    public void afterNotify() {
        System.out.println("********@After我是后置通知");
    }

    @AfterReturning(value="pointCut()")
    public void  afterReturning(){
        System.out.println("********@AfterReturning我是返回后通知");
    }
    @AfterThrowing(value="pointCut()")
    public void afterThrowingNotify() {
        System.out.println("********@AfterThrowing我是异常通知");
    }

    @Around(value="pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object retvalue = null;
        System.out.println("我是环绕通知之前AAA");
        retvalue = proceedingJoinPoint.proceed();
        System.out.println("我是环绕通知之后BBB");
        return retvalue ;
    }

}