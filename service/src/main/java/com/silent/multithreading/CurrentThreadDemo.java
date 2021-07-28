package com.silent.multithreading;

public class CurrentThreadDemo {

    public static void main(String[] args) {
        MyRunable myRunable1=new MyRunable("myRunnable1");
        MyRunable myRunable2=new MyRunable("myrunnable2");
        MyRunable myRunable3=new MyRunable("myRunnable3");
        Thread thread1=new Thread(myRunable1);
        Thread thread2=new Thread(myRunable2);
        Thread thread3=new Thread(myRunable3);
        thread1.start();
        thread2.start();
        thread3.start();


    }
}
