package com.silent.jvm.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassloaderCheck {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassloader myClassloader=new MyClassloader("C:\\workplace\\java-study\\service-java-base-test\\target\\classes\\com\\silent\\jvm\\","Refelct");
        Class c=myClassloader.loadClass("com.silent.jvm.reflection.Refelct");
        System.out.println(c.getClassLoader());
        c.newInstance();
        System.out.println(c.getName());
        Refelct refelct=(Refelct)c.newInstance();
        Method sayhi=c.getMethod("sayHi",String.class);
        sayhi.invoke(refelct,"welcome ");

    }
}
