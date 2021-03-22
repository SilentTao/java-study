package com.silent.redis;

import com.silent.redis.config.RedisConfig;
import redis.clients.jedis.Jedis;

import java.util.Vector;

/**
 * Author liutao
 * Date 2020/5/29 9:37 上午
 * Description:
 * Version: 1.0
 **/
public class GeoaddOperation {

    public static void main(String[] args) throws InterruptedException {
      Jedis jedis= RedisConfig.getJedis();
//      jedis.geoadd("myMap",13f,23f,"xiaomi");
//      jedis.geoadd("myMap",13f,24f,"baidu");
//      jedis.geoadd("myMap",12f,34f,"timi");
//      jedis.geoadd("myMap",13.23f,24.234f,"vipkid");
//
//        System.out.println(jedis.geodist("myMap","xiaomi","xiaomi"));
//        System.out.println(jedis.geopos("myMap","xiaomi","vipkid"));
//
        jedis.setex("aaa",1,"cccc");
        System.out.println( jedis.get("aaa"));
    Thread.sleep(2000);
        System.out.println( jedis.get("aaa"));

        Vector<Boolean> dp=new Vector<>();
    }
}
