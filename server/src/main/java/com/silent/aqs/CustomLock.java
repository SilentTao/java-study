package com.silent.aqs;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liutao
 * Date 2021/6/16 8:09 上午
 * Description:
 * Version: 1.0
 **/
public class CustomLock {
    volatile  int  status=0;
    private ReentrantLock reentrantLock=new ReentrantLock(false);




    public  void lock(){
        LockSupport.park();
        LockSupport.unpark(null);

    }

    public void unlock(){



    }



}
