package com.itz.cloud.aop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud.aop
 * @Version 1.0
 * @date 2021/3/7 23:09
 */
public class CalculatorProxy {
    public static Object getInstance(MyCalculatorImpl myCalculator){
        return Proxy.newProxyInstance(CalculatorProxy.class.getClassLoader(), myCalculator.getClass().getInterfaces(), new InvocationHandler() {
            /**
             *
             * @param proxy 代理对象
             * @param method 代理的方法
             * @param args 方法的参数
             * @return  方法的返回值
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName()+" 方法开始执行了");
                Object invoke = method.invoke(myCalculator, args);
                System.out.println(method.getName()+" 方法执行结束了");
                return invoke;
//                return 99;
            }
        });
    }
}
