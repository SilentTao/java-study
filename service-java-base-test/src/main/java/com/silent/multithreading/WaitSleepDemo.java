package com.silent.multithreading;

/**
 * 主要用于比较wait 和sleep的区别，
 * 1.sleep是Thread类中的方法，是一个native方法，wait是object中的方法，
 * 2.sleep的时候是不会释放锁和cup的，wait会释放资源（cup,锁）
 * 3.sleep外部可以使用，wait只能够在synchronized中使用
 *
 *
 * 锁池（EntryList）和等待池(WaitList)
 * notifyAll 会让所有处于等待池总的线程去竞争锁池中的锁
 * notify   会随机让一个线程去竞争线程池中的锁
*/
public class WaitSleepDemo {

    public static void main(String[] args) {
        final Object lock=new Object();
       new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock){
                    System.out.println("thread A get lock ");
                    try {
                        Thread.sleep(20);
                    System.out.println("thread A do wait method");
                    lock.wait();
                      //  Thread.sleep(1000);
                    System.out.println("Thread A is notify");
                    System.out.println("thread A is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread Bis waiting to get lock");
                synchronized (lock){
                    System.out.println("thread B get lock ");
                    try {
                        Thread.sleep(20);
                        lock.notifyAll();
                        System.out.println("thread B do wait method");
                        System.out.println("thread B is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}
