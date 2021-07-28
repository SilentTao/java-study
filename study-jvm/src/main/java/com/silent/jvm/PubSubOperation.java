package com.silent.jvm;

import com.silent.jvm.config.RedisConfig;
import redis.clients.jedis.Jedis;

/**
 * Author liutao
 * Date 2020/6/2 9:19 上午
 * Description:
 * Version: 1.0
 **/
public class PubSubOperation {

    public static void main(String[] args) {
        Jedis jedis= RedisConfig.getJedis();
        jedis.publish("aaa","bbb");
        jedis.publish("aaa","cccc");
    }



}
