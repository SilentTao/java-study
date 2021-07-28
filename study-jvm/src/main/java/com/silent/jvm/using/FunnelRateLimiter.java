package com.silent.jvm.using;

import java.util.HashMap;
import java.util.Map;

/**
 * Author liutao
 * Date 2020/5/29 8:49 上午
 * Description: 流量漏斗
 * Version: 1.0
 **/
public class FunnelRateLimiter {

    private Map<String, Funnel> funnels = new HashMap<>();

    /**
     *
     * @param userId
     * @param actionKey
     * @param capacity
     * @param leakingRate
     * @return
     */
    public boolean isActionAllowed(String userId, String actionKey, int capacity, float leakingRate) {
        String key = String.format("%s:%s", userId, actionKey);
        Funnel funnel = funnels.get(key);
        if (funnel == null) {
            funnel = new Funnel(capacity, leakingRate);
            funnels.put(key, funnel);
        }
        // 需要 1 个 quota
        return funnel.watering(1);
    }

    static class Funnel {
        /**
         *  // 漏斗容量
         */
        int capacity;
        /**
         * 漏嘴流水速率
         */
        float leakingRate;
        /**
         *漏斗剩余空间
         */
        int leftQuota;
        /**
         *上一次漏水时间
         */
        long leakingTs;

        public Funnel(int capacity, float leakingRate) {
            this.capacity = capacity;
            this.leakingRate = leakingRate;
            this.leftQuota = capacity;
            this.leakingTs = System.currentTimeMillis();
        }

        void makeSpace() {
            long nowTs = System.currentTimeMillis();
            long deltaTs = nowTs - leakingTs;
            int deltaQuota = (int) (deltaTs * leakingRate);
            // 间隔时间太长，整数数字过大溢出
            if (deltaQuota < 0) {
                this.leftQuota = capacity;
                this.leakingTs = nowTs;
                return;
            }
            // 腾出空间太小，最小单位是 1
            if (deltaQuota < 1) {
                return;
            }
            this.leftQuota += deltaQuota;
            this.leakingTs = nowTs;
            if (this.leftQuota > this.capacity) {
                this.leftQuota = this.capacity;
            }
        }

        boolean watering(int quota) {
            makeSpace();
            if (this.leftQuota >= quota) {
                this.leftQuota -= quota;
                return true;
            }
            return false;
        }


    }


}
