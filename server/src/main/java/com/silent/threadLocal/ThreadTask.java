package com.silent.threadLocal;

import java.util.concurrent.Callable;

/**
 * Author liutao
 * Date 2019/12/10 9:51 上午
 * Description:
 * Version: 1.0
 **/
public class ThreadTask implements Runnable {

    private int i;

    ThreadTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("线程 i start " + i);
        try {
            //睡眠2秒
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程 i end " + i);
    }


}
