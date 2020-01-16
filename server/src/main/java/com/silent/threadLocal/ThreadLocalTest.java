package com.silent.threadLocal;

/**
 * Author liutao
 * Date 2019/12/11 10:22 上午
 * Description:
 * Version: 1.0
 **/
public class ThreadLocalTest {

  public  static    ThreadLocal<Object> threadLocal=new ThreadLocal();

    public static void main(String[] args) {

//        threadLocal.set("asd");
//        System.out.println(threadLocal.get());

        new Thread(new UserTask(threadLocal,"task1")).start();
        new Thread(new UserTask(threadLocal,"task2")).start();


    }
}
