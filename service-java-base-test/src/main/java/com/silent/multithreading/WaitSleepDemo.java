package com.silent.multithreading;

/**
 * 主要用于比较wait 和sleep的区别，
 * 1.sleep是Thread类中的方法，是一个native方法，wait是object中的方法，
 * 2.sleep的时候是不会释放锁和cup的，wait会释放资源（cup,锁）
 * 3.sleep外部可以使用，wait只能够在synchronized中使用
 * <p>
 * <p>
 * 锁池（EntryList）和等待池(WaitList)
 * notifyAll 会让所有处于等待池总的线程去竞争锁池中的锁
 * notify   会随机让一个线程去竞争线程池中的锁
 */
public class WaitSleepDemo {

    public static void main(String[] args) {
        //创建锁对象
        final Object lock = new Object();
        // 线程AAA
      Thread aaa=  new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread AAA is waiting to get lock");
                synchronized (lock) {
                    System.out.println("thread AAA get lock ");
                    try {

                        System.out.println("thread AAA do wait method");
                        Thread.sleep(40);
                       // Thread.sleep(20);
                        System.out.println("thread AAA is done");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
      aaa.start();

        try {
            //主线程睡眠10毫秒等待让两个线程启动有个竞争锁的过程
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 线程BBB
       Thread bbb= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread BBB is waiting to get lock");
                synchronized (lock) {
                    System.out.println("thread BBB get lock ");
                    try {
                       Thread.sleep(20);
                        System.out.println("thread BBB do wait method");
                        System.out.println("thread BBB is done");
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        bbb.start();
    }
}
