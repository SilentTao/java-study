package com.silent.multithreading;

/**
 * \* User: silent
 * \* Date: 08/03/19 Time: 11:38
 * \* Description:
 * \
 */
public class ATheadSynchronizeTest {

    public static void main(String[] args) {
        AObjcet a1 = new AObjcet();
        AObjcet a2 = new AObjcet();
        Thread a = new Thread(new AThread(a1, 1));
        Thread b = new Thread(new AThread(a2, 2));
        a.start();
        b.start();
    }
}
