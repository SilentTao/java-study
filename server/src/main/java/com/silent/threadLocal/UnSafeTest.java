package com.silent.threadLocal;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Author liutao
 * Date 2019/12/12 10:23 上午
 * Description:
 * Version: 1.0
 **/
public class UnSafeTest {

    private static final Unsafe unsafe = Unsafe.getUnsafe();


    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        User user=new User("kai","男");
        System.out.println(user.toString());
        Field name = user.getClass().getDeclaredField("name");
        Method show=user.getClass().getMethod("show");
        long nameOffset = unsafe.objectFieldOffset(name);
        unsafe.putObject(user, nameOffset, "jim");
        System.out.println(user.toString());
    }
}
