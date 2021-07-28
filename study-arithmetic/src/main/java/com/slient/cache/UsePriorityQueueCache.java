package com.slient.cache;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liutao
 * Date 2021/7/23 3:03 下午
 * Description:
 * 基于优先级队列实现,
 * 暂时不考虑并发问题, 后边再考虑 , 考虑使用读写锁进行处理
 *
 * 支持两种模式, 1.使用频率, 2.增加有效期的控制
 * Version: 1.0
 **/
@Log4j
@Data
public class UsePriorityQueueCache {


    /**
     * 缓存大小默认为100
     */
    private int cacheSize = 100;
    private PriorityQueue<CacheItem> priorityQueue;
    /**
     * 后边可以替换成其他的存储方式,比如数组
     */
    private HashMap<String, CacheItem> map;
    /**
     * 模式, 支持访问频率, 支持按照最近使用时间 来进行缓存支持, 后续支持混和模式
     */
    private String moduleType;

    private ReentrantLock lock=new ReentrantLock();

    UsePriorityQueueCache() {
        //default cacheSize=100;
        Comparator<CacheItem> comparator = (o1, o2) -> o1.hitCount > o2.hitCount ? 0 : 1;
        priorityQueue = new PriorityQueue<>(comparator);
    }

    UsePriorityQueueCache(int cacheSize) {
        Comparator<CacheItem> comparator = (o1, o2) -> o1.hitCount > o2.hitCount ? 0 : 1;
        priorityQueue = new PriorityQueue<>(comparator);
        map = new HashMap<>(cacheSize);
        this.cacheSize = cacheSize;
    }


    /**
     * 查询缓存, 有返回缓存值,
     *
     * @param key
     * @return
     */
    public synchronized String getCache(String key) {
        //首先获取
        CacheItem cacheItem = map.get(key);
        if (cacheItem == null) {
            cacheItem = addNewCache(key);
        } else {
            cacheItem = addOldCache(cacheItem);
        }
        return JSONObject.toJSONString(cacheItem);
    }

    /**
     * 新增新的缓存
     *
     * @param key
     * @return
     */
    private CacheItem addNewCache(String key) {
        //写入新的缓存值
        CacheItem cacheItem = new CacheItem();
        cacheItem.key = key;
        cacheItem.addTime = System.currentTimeMillis() / 1000;
        cacheItem.setHitCount(0);
        if (priorityQueue.size() < cacheSize) {
            priorityQueue.add(cacheItem);
        } else {
            //移出顶部, 加入新的缓存
            CacheItem cacheItemOld = priorityQueue.poll();
            assert cacheItemOld != null;
            //移出旧缓存的存储
            map.remove(cacheItemOld.getKey());
            priorityQueue.add(cacheItem);
        }
        //跟下map缓存
        map.put(key, cacheItem);
        return cacheItem;
    }

    /**
     * 更新缓存
     *
     * @param cacheItem
     * @return
     */
    private CacheItem addOldCache(CacheItem cacheItem) {
        //先删除
        boolean success = priorityQueue.remove(cacheItem);
        //写入新的缓存值
        cacheItem.addTime = System.currentTimeMillis() / 1000;
        //查询字数增加i
        cacheItem.setHitCount(cacheItem.getHitCount() + 1);
        priorityQueue.add(cacheItem);
        map.put(cacheItem.getKey(), cacheItem);
        return cacheItem;
    }

    @Data
    private class CacheItem {

        private String key;

        private int hitCount;
        /**
         * 加入时间
         */
        private long addTime;
    }


}
