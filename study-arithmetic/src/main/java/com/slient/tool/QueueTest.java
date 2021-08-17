package com.slient.tool;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liutao
 * Date 2021/8/16 2:44 下午
 * Description:
 * Version: 1.0
 **/
public class QueueTest {


    /**
     * @see java.util.Collection
     * @see java.util.LinkedList
     * @see java.util.PriorityQueue
     * @see java.util.concurrent.LinkedBlockingQueue
     * @see java.util.concurrent.BlockingQueue
     * @see java.util.concurrent.ArrayBlockingQueue
     * @see java.util.concurrent.PriorityBlockingQueue
     **/
    public static void main(String[] args) {
        //
        //LinkList
        Queue<String> linkList = new LinkedList<>();


        // 优先级队列
        // 可以实现大顶堆, 小顶堆,
        // 特点:
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        priorityQueue.add(1);
        priorityQueue.add(2);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
        //LinkedBlockingQueue
        // 特点:
        // 线程安全, 阻塞,  删除
        /**
         * 特点:
         *  1. 线程安全, 基于ReentrantLock实现 ,持有两把锁, put锁, take锁, 基于Condition实现线程的唤醒和等待, 计数器使用AtomicInteger,
         *  2. 基于链表实现, 先入先出,
         *  3.
         *  阻塞的操作 , 阻塞并等待
         *      入队: put() ,
         *      出队: take()
         *  非阻塞的操作
         *      入队: add(--> offer()
         *      出队: poll(), remove()
         *
         *
         * 大小: 默认为int的最大值
         * 不允许为空的元素插入
         */
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
        linkedBlockingQueue.add("aaa");
        linkedBlockingQueue.add("bbb");
        linkedBlockingQueue.offer("ccc");


        while (!linkedBlockingQueue.isEmpty()) {
            System.out.println(linkedBlockingQueue.poll());
        }
        /**
         * 基于数组实现, 初始化必须制定大小,无法进行扩容,内部使用了一把锁对插入和取出做了限制，即插或者取的操作是原子性
         * 读取操作一把锁, 效率上会逊色于linkedBlockingQueue;
         *
         */
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(100);
        arrayBlockingQueue.add("array01");
        arrayBlockingQueue.offer("array02");



    }


}
