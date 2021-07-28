package com.silent.jvm;

import com.silent.jvm.config.RedisConfig;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Author liutao
 * Date 2020/6/2 9:36 上午
 * Description:
 * Version: 1.0
 **/
public class ZsetOperation {

    public static void main(String[] args) {
        Jedis jedis = RedisConfig.getJedis();
        String key = "bb";
//
//        for (int i = 0; i < 512; i++) {
//            jedis.zadd(key, i, "aa"+i);
//        }
//        List<String> aaaa=new ArrayList<>();
//        aaaa.add("aa1");
//        aaaa.add("aa2");
//        aaaa.add("aa3");
//
//
//        jedis.zrem(key, aaaa.toArray(new String[0]));
//
//        Set<String> setRange = jedis.zrange(key, 0, 100);
//
//        System.out.println(setRange.toString());
        Set<String> setByScore = jedis.zrangeByScore(key, 0, 100);
        System.out.println(setByScore.toString());



    }


}
