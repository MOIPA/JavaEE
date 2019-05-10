package com.tr.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

//通知类
public class MyAdvice {

    //前置通知 目标方法运行之前调用

    //后置通知  之后

    //环绕通知 目标方法之前和之后

    //异常拦截通知 如果异常就调用

    //后置通知   想trycatch里的finally

    public void before() {
        System.out.println("前置通知");
    }
    public void afterReturning() {
        System.out.println("后置通知");
    }

    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知");
        Object proceed = pjp.proceed();//调用目标方法
        System.out.println("环绕通知");
        return proceed;
    }
    public void afterException() {
        System.out.println("异常通知");
    }
    public void after() {
        System.out.println("后置通知（不管怎么样都调用）");
    }

}
