package com.silent.gc;

import java.lang.ref.SoftReference;

/**
 * \* User: silent
 * \* Date: 07/03/19 Time: 10:32
 * \* Description:
 * \
 */
public class WeakReferenceDemo {

    public static void main(String[] args) throws InterruptedException {
        WeakObject weakObject = new WeakObject(new Student());
        WeakObject weakObject1 = new WeakObject(new Student());
        WeakObject weakObject3 = new WeakObject(new Student());

        System.out.println("weakObject : " + weakObject.get());
        System.gc();
        Thread.sleep(1000);
        System.out.println("==========");
        System.out.println("weakObject : " + weakObject.get());


    }
}
