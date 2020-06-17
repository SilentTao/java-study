package com.silent.aop;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * Author liutao
 * Date 2020/5/22 9:55 上午
 * Description:
 * 使用ProxyFactory创建对象
 *
 * Version: 1.0
 **/
public class SimpleBeforeAdvice implements MethodBeforeAdvice {


    public static void main(String[] args) {
        Singer singer=new Singer();
        ProxyFactory proxyFactory=new ProxyFactory();
        proxyFactory.addAdvice(new SimpleBeforeAdvice());
        //设置代理对象
        proxyFactory.setTarget(singer);
        Singer singerProxy=(Singer)proxyFactory.getProxy();
        singerProxy.sing();

    }




    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("method is " + method + " , objects is " + objects.toString() + " ,Object is " + o.toString());
    }
}
