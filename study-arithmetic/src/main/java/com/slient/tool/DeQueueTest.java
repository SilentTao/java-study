package com.slient.tool;

import java.util.ArrayDeque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author liutao
 * Date 2021/8/16 5:48 下午
 * Description:  双端队列
 * Version: 1.0
 **/
public class DeQueueTest {

    public static void main(String[] args) {
        /**
         * 基于数组实现的, 不安全的双端队列, 默认大小16
         */
        ArrayDeque<String> deque = new ArrayDeque<>();




        /**
         * 基于链表实现的阻塞双端队列
         */
        LinkedBlockingDeque<String> linkDeque = new LinkedBlockingDeque<>();


        /**
         * 线程安全的双端队列
         */
        ConcurrentLinkedDeque<String> aaa = new ConcurrentLinkedDeque<>();


    }
}
