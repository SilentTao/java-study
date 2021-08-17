package com.silent.multithreading;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author liutao
 * Date 2021/8/12 11:25 上午
 * Description:
 * 目标实现一个操作队列来减轻对于数据库读写的压力
 * Version: 1.0
 **/
public class QuqueTask {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadFactory factory= new  ThreadFactoryBuilder().setNameFormat("测试").build();
        //
        ExecutorService executorService=  new ThreadPoolExecutor(1,
                5,
                10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100 * 5000),// 设置低劣大小
                factory);

        FutureTask<String> futureTask=new FutureTask<String>(() -> {
            TimeUnit.MILLISECONDS.sleep(10);
            return  "aaa";
        });
        executorService.submit(futureTask);

       String data= futureTask.get();
        System.out.println(data);
    }

}
