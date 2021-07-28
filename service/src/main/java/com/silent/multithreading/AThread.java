package com.silent.multithreading;

/**
 * \* User: silent
 * \* Date: 08/03/19 Time: 11:33
 * \* Description:
 * \
 */
public class AThread implements Runnable {

    private AObjcet aObjcet;
    private  int num;
    public  AThread (AObjcet aObjcet,int num){
        this.aObjcet=aObjcet;
        this.num=num;
    }

    /**
     * 死循环持续查看打印结果
     */
    public void run() {
        while (true){
            aObjcet.printNum(num);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
