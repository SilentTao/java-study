package com.silent.redis.config;

import redis.clients.jedis.Jedis;

/**
 * Author liutao
 * Date 2020/5/28 9:50 上午
 * Description:
 * Version: 1.0
 **/
public class RedisConfig {

    public static Jedis jedis;


    public static Jedis getJedis() {
        if (jedis == null) {
            jedis = new Jedis("127.0.0.1", 6379);
        }
        return jedis;
    }




}
