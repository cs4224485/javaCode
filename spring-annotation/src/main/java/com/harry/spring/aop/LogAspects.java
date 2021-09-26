package com.harry.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 切面类
 * @author liayun
 *
 */
@Aspect
public class LogAspects {

    // 如果切入点表达式都一样的情况下，那么我们可以抽取出一个公共的切入点表达式
    @Pointcut("execution(public int com.harry.spring.aop.MathCalculator.*(..))")
    public void pointCut() {}


    // @Before：在目标方法（即div方法）运行之前切入，public int com.harry.spring.aop.MathCalculator.div(int, int)这一串就是切入点表达式，指定在哪个方法切入
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs(); // 拿到参数列表，即目标方法运行需要的参数列表
        System.out.println(joinPoint.getSignature().getName() + "运行......@Before，参数列表是：{" + Arrays.asList(args) + "}");

    }

    // 在目标方法（即div方法）结束时被调用
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "结束......@After");
    }

    // 在目标方法（即div方法）正常返回了，有返回值，被调用
    @AfterReturning(value="pointCut()", returning="result") // returning来指定我们这个方法的参数谁来封装返回值
    // 一定要注意：JoinPoint这个参数要写，一定不能写到后面，它必须出现在参数列表的第一位，否则Spring也是无法识别的，就会报错
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + "正常返回......@AfterReturning，运行结果是：{" + result + "}");
    }

    @AfterThrowing(value="pointCut()", throwing="exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        // System.out.println("除法出现异常......异常信息：{}");

        System.out.println(joinPoint.getSignature().getName() + "出现异常......异常信息：{" + exception + "}");
    }


    // 在目标方法（即div方法）出现异常，被调用
    @AfterThrowing("pointCut()")
    public void logException() {
        System.out.println("除法出现异常......异常信息：{}");
    }

}
