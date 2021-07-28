package com.silent.jvm.memory;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.util.HashMap;

/**
 * @author liutao
 * Date 2021/7/1 4:28 下午
 * Description:
 * Version: 1.0
 **/
public class JOLTest {

    private static Object  o;
    public static void main(String[] args) {
        o = new Object();
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
