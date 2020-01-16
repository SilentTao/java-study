package com.silent.threadLocal;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Author liutao
 * Date 2019/12/10 10:26 上午
 * Description:
 * Version: 1.0
 **/
public class ScheduleThreadTest {


    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleWithFixedDelay(new ThreadTask(1),1,1, TimeUnit.SECONDS);
//        ScheduledExecutorService scheduledExecutorServiceCustom=
    }
}
