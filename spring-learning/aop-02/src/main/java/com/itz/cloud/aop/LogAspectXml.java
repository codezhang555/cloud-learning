package com.itz.cloud.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * xml方式配置aop
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud.aop
 * @Version 1.0
 * @date 2021/3/7 23:22
 */
public class LogAspectXml {


    /**
     * 前置通知，在目标方法执行之前执行
     * @param joinPoint
     */
    public void before(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println(name + " 方法开始执行了...");
    }

    /**
     * 后置通知，在目标方法执行之后通知
     * @param joinPoint
     */
    public void after(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println(name + " 方法执行结束了...");
    }

    /**
     * 返回通知，可以在该方法中获取目标方法的返回值，如果目标方法的返回值为void,则收到null
     * @param joinPoint
     * @param r  返回的参数名称，和这里方法的参数名一一对应
     */
    public void returning(JoinPoint joinPoint,Integer r){
        String name = joinPoint.getSignature().getName();
        System.out.println(name + " 返回通知:"+ r);
    }

    /**
     * 异常通知，当目标方法抛出异常时，该方法被触发
     * @param joinPoint
     * @param e 异常参数,和方法的参数名一一对应，注意异常的类型,
     */
    public void afterThrowing(JoinPoint joinPoint,Exception e){
        String name = joinPoint.getSignature().getName();
        System.out.println(name + " 方法异常通知:"+ e.getMessage());
    }

    /**
     * 环绕通知，环绕通知是上面四种通知的集大成者，环绕通知的核心类似于在反射中执行方法
     * @param joinPoint
     * @return
     */
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //类似于method.invoke()方法，可以在这个方法的前后分别添加日志，相当于前置/后置通知
        Object proceed = joinPoint.proceed();
        return proceed;
    }

}
