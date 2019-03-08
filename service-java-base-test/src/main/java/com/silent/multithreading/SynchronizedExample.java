package com.silent.multithreading;

/**
 * \* User: silent
 * \* Date: 07/03/19 Time: 16:57
 * \* Description:
 * \
 */
public class SynchronizedExample {
    private static int volatileOjbct = 12;


    /**
     * 测试多线程的对于变量的可见性
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        volatileOjbct = 122;
        Thread thread = new Thread(() -> {
            changeX(volatileOjbct);
        });
        volatileOjbct = 130;
        thread.start();
        thread.join();

    }

    static synchronized void changeX(Integer x) {
        volatileOjbct = 5;
        System.out.println("我是 x :" + x);
    }
}
