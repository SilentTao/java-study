package com.base;


import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * @author liutao
 * Date 2021/7/2 10:45 上午
 * Description:
 * Version: 1.0
 **/
public class QueueTest {

    public static void main(String[] args) {
      Queue<Integer> queue=new LinkedBlockingQueue<>();

      Queue<Integer> queue1=new LinkedTransferQueue<>();
      //优先级队列
      Queue<Integer> queue2=new PriorityQueue<Integer>();


        LinkedHashMap<String,String> hashMap=new LinkedHashMap<>();
        HashMap<String,String> hashMa1p=new HashMap<>();
        hashMap.put("aaa","bbb");
        hashMap.remove("aaa");
        Comparator comparator=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer) o2-(Integer) o1;
            }
        };
        PriorityQueue priorityQueue=new PriorityQueue<>(100,comparator);

        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);

        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }


    }


}
