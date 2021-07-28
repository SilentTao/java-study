package com.silent.synchroized;


/**
 * @author liutao
 * Date 2021/6/19 6:00 下午
 * Description:
 * Version: 1.0
 **/
public class Test {

    Object lock=new Object();
    private  int number=0;

    public void send(){
        synchronized (lock){
            System.out.println("get lock");
        }
    }

    public synchronized void  send1(){
        number++;
    }

}
