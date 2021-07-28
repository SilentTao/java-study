package com.silent.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * \* User: silent
 * \* Date: 07/03/19 Time: 10:32
 * \* Description:
 * java -XX:+PrintGCDetails -Xms10M -Xmx10M  ReferenceQueueDemo
 * \
 */
public class ReferenceQueueDemo {
    private static ReferenceQueue<byte[]> rq = new ReferenceQueue<byte[]>();
    private static int _1M = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        Object value = new Object();
        Map<Object, Object> map = new HashMap<>();
        Thread thread = new Thread(() -> {
            try {
                int cnt = 0;
                WeakReference<byte[]> k;
                while ((k = (WeakReference) rq.remove()) != null) {
                    System.out.println((cnt++) + "回收了:" + k);
                }
            } catch (InterruptedException e) {
                //结束循环
            }
        });
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 10000; i++) {
            byte[] bytes = new byte[_1M];
            WeakReference<byte[]> weakReference = new WeakReference<byte[]>(bytes, rq);
            map.put(weakReference, value);
        }
        System.out.println("map.size->" + map.size());
    }


}
