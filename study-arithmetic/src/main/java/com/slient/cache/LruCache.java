package com.slient.cache;

import lombok.Data;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liutao
 * Date 2021/7/26 10:36 上午
 * Description:
 * Version: 1.0
 **/
@Log4j2
public class LruCache {

    private final Object lock = new Object();
    /**
     * 最大缓存大小, 默认为1k
     */
    private int cacheMax;
    /**
     * 链表头
     */
    private DoubleLinkedList head = new DoubleLinkedList();
    /**
     * 链表尾部
     */
    private DoubleLinkedList tail = new DoubleLinkedList();
    /**
     * 初始化读写锁
     * <p>
     * 思考, 如何通过key维度的去做锁定
     */
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private final Lock rlock = reentrantReadWriteLock.readLock();
    private final Lock wlock = reentrantReadWriteLock.writeLock();
    /**
     * hash表, 能够O(1)时间复杂度的查询缓存
     *
     * @param lruSize
     */
    private HashMap<String, DoubleLinkedList> doubleLinkedListHashMap;

    LruCache(int lruSize) {
        doubleLinkedListHashMap = new HashMap<>(lruSize);
        cacheMax = lruSize;
        head.prv = null;
        head.next = tail;
        tail.prv = head;
        tail.next = null;
    }

    LruCache() {
        //默认缓存大小为10
        cacheMax = 10;
        doubleLinkedListHashMap = new HashMap<>(cacheMax);
        head.prv = null;
        head.next = tail;
        tail.prv = head;
        tail.next = null;
    }

    /**
     * 获取缓存
     *
     * @param key
     * @return
     */
    public String getCache(String key) {
        String data = null;
        rlock.lock();
        try {
            DoubleLinkedList doubleLinkedList = doubleLinkedListHashMap.get(key);
            if(doubleLinkedList==null){
                return null;
            }
            data = doubleLinkedList.getData();
            log.info("key is {}, data is {}",key,doubleLinkedList.getData());
        } finally {
           rlock.unlock();
        }
        return data;
    }

    /**
     * 插入缓存
     *
     * @param key
     * @param data
     * @return
     */
    public void setCache(String key, String data) {
        wlock.lock();
        try {
            System.out.println("我开始写拉");
            DoubleLinkedList doubleLinkedList = doubleLinkedListHashMap.get(key);
            if (doubleLinkedList == null) {
                if (doubleLinkedListHashMap.size() >= cacheMax) {
                    //如果hashMap的大小大于或者等于最大缓存数, 淘汰链表最尾部元素
                    DoubleLinkedList remove = tail.prv;
                    remove.prv.next = tail;
                    tail.prv = remove.prv;
                    //防止内存泄露,回收无用应用块, 这里有块坑,链表删除一定得记得吧删除节点的前后应用给去掉,
                    remove.next = null;
                    remove.prv = null;
                    doubleLinkedListHashMap.remove(remove.getKey());
                }
                //构建插入节点
                doubleLinkedList = new DoubleLinkedList();
                doubleLinkedList.setData(data);
                doubleLinkedList.setKey(key);
                //加入first
                addFristNodeLinkList(doubleLinkedList);
                doubleLinkedListHashMap.put(key, doubleLinkedList);
            } else {
                //更新数据
                doubleLinkedList.setData(data);
                //移动链表
                //摘出修改的链表
                doubleLinkedList.prv.next = doubleLinkedList.next;
                doubleLinkedList.next.prv = doubleLinkedList.prv;
                //修改当前节点的前后的节点
                addFristNodeLinkList(doubleLinkedList);
                doubleLinkedListHashMap.put(key, doubleLinkedList);
            }
            System.out.println("我写完了");
        } finally {
            wlock.unlock();
        }

    }

    /**
     * 新节点加入链表首部
     *
     * @param doubleLinkedList
     */
    private void addFristNodeLinkList(DoubleLinkedList doubleLinkedList) {
        doubleLinkedList.prv = head;
        doubleLinkedList.next = head.next;
        head.next.prv = doubleLinkedList;
        head.next = doubleLinkedList;

    }

    public void printAllCache() {
        log.info("==========开始打印HashMap所有缓存============");
        for (HashMap.Entry<String, DoubleLinkedList> data : doubleLinkedListHashMap.entrySet()) {
            log.info("节点数据key为: {}, value 为 {}", data.getKey(), data.getValue().getData());
        }
        log.info("==========结束打印HashMap所有缓存============");

        log.info("==========按照节点顺序打印============");
        DoubleLinkedList currentLink = head;
        while (currentLink != null) {
            //不打印头节点
            if (currentLink.prv != null && currentLink.next != null) {
                log.info("节点数据key为: {}, value 为 {}", currentLink.getKey(), currentLink.getData());
            }
            currentLink = currentLink.next;
        }

        log.info("==========按照节点顺序打印============");

    }

    /**
     * 双向链表
     */
    @Data
    @ToString
    class DoubleLinkedList {
        private String data;
        //上一位
        private DoubleLinkedList prv;
        //下一位
        private DoubleLinkedList next;
        private String key;

    }


}
