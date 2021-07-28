package com.silent.jvm.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ByteCodeSample {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        Class rc=Class.forName("com.silent.jvm.reflection.Refelct");
        Refelct refelct=(Refelct)rc.newInstance();
        System.out.println("class name is "+rc.getName());
        Method getHello=rc.getDeclaredMethod("thowHello",String.class);
        getHello.setAccessible(true);
        Object str=getHello.invoke(refelct,"Bob");
        System.out.println("getHello result is "+str);
        Method sayhi=rc.getMethod("sayHi",String.class);
        sayhi.invoke(refelct,"welcome ");
        Field name=rc.getDeclaredField("name");
        name
                .setAccessible(true);
        name.set(refelct,"silent");
        sayhi.invoke(refelct,"weclome  ");

    }
}
