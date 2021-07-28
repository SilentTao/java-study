package com.silent.multithreading;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author liutao
 * Date 2021/6/19 5:02 下午
 * Description:
 * Version: 1.0
 **/
public class CompletionServiceTest {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadFactory MESSAGE_PUSH_THREAD_FACTORY = new ThreadFactoryBuilder().setNameFormat("消息推送主线程-pool-%d").build();
        ExecutorService service = new ThreadPoolExecutor(1,
               5,
                10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100 * 5000),
                MESSAGE_PUSH_THREAD_FACTORY);

        CompletionService<String> completionService=new ExecutorCompletionService<String>(service);

        for (int i = 0; i < 5; i++) {
            completionService.submit(new ReturnAfterSleepCallable(i));
        }
        System.out.println("after submit");
        for (int i = 0; i < 5; i++) {
            System.out.println("result: " + completionService.take().get()); // 这个方法是阻塞的
        }
        System.out.println("after get");
        service.shutdown();
    }


}
