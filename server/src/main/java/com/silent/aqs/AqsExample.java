package com.silent.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liutao
 * Date 2021/6/16 7:56 上午
 * Description:
 * Version: 1.0
 **/
public class AqsExample {

    ReentrantLock lock=new ReentrantLock();

    public void lockDemo(){

        Thread t1=new Thread(()->{
            System.out.println("thread1");
            lock.lock();
            try {

                    Thread.sleep(2);
            }catch (Exception e){

            }
            finally {
                lock.unlock();
            }
            System.out.println("thread1-end");

        });
    t1.start();

        Thread t2=new Thread(()->{
            System.out.println("thread2");

            lock.lock();
            try {

                Thread.sleep(1);
            }catch (Exception e){

            }
            finally {
                lock.unlock();
            }
            System.out.println("thread2-end");

        });

    t2.start();
    }
}
