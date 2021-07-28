package com.silent.multithreading;

/**
 * \* User: silent
 * \* Date: 08/03/19 Time: 11:33
 * \* Description:
 * \
 */
public class AObjcet {
    private static volatile Object lock = new Object();

    public void printNum(int num) {

        synchronized (lock) {

            System.out.println(Thread.currentThread()+"m :"+num+"lock "+lock);
            for(int i=0;i<25;i++){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }


}
