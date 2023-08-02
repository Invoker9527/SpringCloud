package com.atguigu.springcloud.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @Author YangRuiHong
 * @Create 2022-02-24 14:35
 * @Description
 */
@Repository
@Aspect
public class ProxyTest {
    /**
     * 开始时间
     */
    public static long beforeTime;

    /**
     * 切入点
     */
    @Pointcut("execution(* com.atguigu.springcloud.bean.User.say(..))")
    public void pointcut() {

    }

    /**
     * 前置通知
     */
    @Before("pointcut()")
    public void before() {
        beforeTime = new Date().getTime();
        System.out.println("前置通知");
        System.out.println("前置执行时间: " + beforeTime);
    }

    /**
     * 后置通知
     */
    @After("pointcut()")
    public void after() {
        System.out.println("后置通知执行时：" + new Date().getTime());
        System.out.println("花费时间:" + (new Date().getTime() - beforeTime) + "ms");
    }

    /**
     * 环绕通知
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Around("pointcut()")
    public void arround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前");
        joinPoint.proceed();
        System.out.println("环绕后");
    }

    /**
     * 异常通知
     */
    @AfterThrowing("pointcut()")
    public void AfterThrowing() {
        System.out.println("AfterThrowing...");
    }

}
