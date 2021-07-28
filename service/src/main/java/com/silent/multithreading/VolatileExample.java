package com.silent.multithreading;

/**
 * \* User: silent
 * \* Date: 07/03/19 Time: 16:23
 * \* Description:
 * \
 */
public class VolatileExample {
    int x = 0;
    volatile boolean v = false;

    public static void main(String[] args) throws InterruptedException {
        VolatileExample volatileExample = new VolatileExample();
        Thread th1 = new Thread(() -> {
            volatileExample.writer();
        });
        Thread th2 = new Thread(() -> {
            volatileExample.reader();
        });
        th2.start();
        th1.start();

        th1.join();
        th2.join();
    }

    public void writer() {
        x = 42;
        v = true;

    }

    public void reader() {
        if (v = true) {
            System.out.println(x);
        }
    }

}
