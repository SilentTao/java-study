package com.slient.cache;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liutao
 * Date 2021/7/23 3:04 下午
 * Description:
 * Version: 1.0
 **/
public class TestController {
    private static ExecutorService executorService = new ThreadPoolExecutor(10, 13, 0,
            TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1000),
            new ThreadFactoryBuilder().setNameFormat("测试线程池子").build());


    public static void main(String[] args) throws InterruptedException {
        testLru();
    }

    /**
     * 测试lru
     * @throws InterruptedException
     */
    private static void testLru() throws InterruptedException {

        LruCache lruCache = new LruCache(5);
        lruCache.setCache("001", "小哥=====A");
        executorService.execute(() -> {

            for (int i = 0; i < 20; i++) {
                executorService.execute(() -> {
                    lruCache.getCache("001");
                });
            }
            lruCache.setCache("001", "小哥B");
        });

        executorService.execute(() -> {
            for (int i = 0; i < 20; i++) {
                executorService.execute(() -> {
                    lruCache.getCache("001");
                });
            }
        });


    }


    private static void testUsePriorityQueueCache() {
        UsePriorityQueueCache lruPriorityQueueCache = new UsePriorityQueueCache(2);
        for (int i = 0; i < 4; i++) {
            String data = lruPriorityQueueCache.getCache("silent");
            System.out.println("silent " + data);

        }
        for (int i = 0; i < 4; i++) {
            String data = lruPriorityQueueCache.getCache("silent01");
            System.out.println("silent01 " + data);
        }
        for (int i = 0; i < 4; i++) {
            String data = lruPriorityQueueCache.getCache("silent02");
            System.out.println("silent02 " + data);
        }
        System.out.println("最终缓存数量" + lruPriorityQueueCache.getPriorityQueue().size());
        while (lruPriorityQueueCache.getPriorityQueue().size() > 0) {
            System.out.println("缓存数据" + lruPriorityQueueCache.getPriorityQueue().poll());
        }
    }


}
