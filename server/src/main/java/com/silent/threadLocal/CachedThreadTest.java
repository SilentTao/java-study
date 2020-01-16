package com.silent.threadLocal;

import java.util.concurrent.*;

/**
 * Author liutao
 * Date 2019/12/10 9:55 上午
 * Description:
 * Version: 1.0
 **/
public class CachedThreadTest {


    public static void main(String[] args) {


        ExecutorService executorService= new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

        for (int i=1;i<100;i++){
            executorService.submit(new ThreadTask(i));
        }

       // executorService.shutdownNow();

    }

}
