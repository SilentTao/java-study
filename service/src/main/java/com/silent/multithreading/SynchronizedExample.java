package com.silent.multithreading;

/**
 * \* User: silent
 * \* Date: 07/03/19 Time: 16:57
 * \* Description:
 * \
 */
public class SynchronizedExample {

    private static volatile int volatileObject = 12;


    /**
     * 测试多线程的对于变量的可见性
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(() -> {
            changeVolatileObject(volatileObject);
        });
        volatileObject = 130;
        thread.start();
        thread.join();

    }

    static  void changeVolatileObject(Integer x) {
        volatileObject = 5;
        System.out.println("我是 x :" + x);
    }



}
