package com.silent.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author liutao
 * Date 2021/6/19 5:03 下午
 * Description:
 * Version: 1.0
 **/
public class ReturnAfterSleepCallable implements Callable<String> {
    int sleep;

    public ReturnAfterSleepCallable(int sleep) {
        this.sleep = sleep;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "睡眠:" + sleep + "秒");
        TimeUnit.SECONDS.sleep(sleep);

        return String.valueOf(sleep);
    }
}
