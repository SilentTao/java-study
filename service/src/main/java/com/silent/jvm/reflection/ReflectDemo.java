package com.silent.jvm.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * \* User: silent
 * \* Date: 06/03/19 Time: 11:53
 * \* Description:
 * \
 */
public class ReflectDemo {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class mr=Class.forName("com.silent.jvm.reflection.MyReflect");

        MyReflect myReflect=(MyReflect)mr.newInstance();
        Method sayHi=mr.getDeclaredMethod("sayHi",String.class);
        sayHi.setAccessible(true);
        sayHi.invoke(myReflect,"silent");
        Method sayBye=mr.getMethod("sayBye",String.class);
        String aaa = (String) sayBye.invoke(myReflect,"silent");
        System.out.println(aaa);
        MyReflect myReflect1=new MyReflect();
       boolean iscommon= mr.isInstance(myReflect1);
        System.out.println(iscommon);

    }
}
