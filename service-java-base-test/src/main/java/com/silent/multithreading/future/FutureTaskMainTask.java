package com.silent.multithreading.future;



import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author liutao
 * Date 2020/9/16 10:20 上午
 * Description:
 * Version: 1.0
 **/
public class FutureTaskMainTask {

    public static void main(String[] args) {
          ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("队列-pool-%d").build();
        ExecutorService executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),namedThreadFactory);





    }

}
