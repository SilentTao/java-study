package com.silent.threadLocal;

import java.util.concurrent.*;

/**
 * Author liutao
 * Date 2019/12/10 9:56 上午
 * Description:
 * Version: 1.0
 **/
public class FixedThreadTest {

    public static void main(String[] args) {
        Executors.newFixedThreadPool(1);
        Executors.newScheduledThreadPool(1);
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        ExecutorService executorService= new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        for (int i=1;i<100;i++){
            executorService.submit(new ThreadTask(i));
        }

    }
}
