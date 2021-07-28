package com.silent.jvm.using;

import com.silent.jvm.config.RedisConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;
import java.util.HashMap;

/**
 * Author liutao
 * Date 2020/5/28 10:09 上午
 * Description:
 * Version: 1.0
 **/
public class SimpleRateLimiter {

    /**
     *
     * @param userId   用户id
     * @param actionKey  用户活动key
     * @param period  时间单位
     * @param maxCount  最大允许次数
     * @return
     *
     * 简单的限流算法, 利用zset
     * @throws IOException
     */
    private static boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) throws IOException {
        Jedis jedis= RedisConfig.getJedis();
        String key = String.format("hist:%s:%s", userId, actionKey);
        long nowTs = System.currentTimeMillis();
        Pipeline pipe = jedis.pipelined();
        pipe.multi();
        pipe.zadd(key, nowTs, "" + nowTs);
        pipe.zremrangeByScore(key, 0, nowTs - period * 1000);
        Response<Long> count = pipe.zcard(key);
        //重置过期时间
        pipe.expire(key, period + 1);
        pipe.exec();
        pipe.close();
        HashMap map=new HashMap();
        return count.get() <= maxCount;

    }




    public static void main(String[] args) throws IOException {
        for(int i=0;i<10;i++){

            System.out.println(isActionAllowed("liutao","test",6,3));

        }
    }

}
