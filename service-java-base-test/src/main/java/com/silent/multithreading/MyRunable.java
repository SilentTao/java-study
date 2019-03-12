package com.silent.multithreading;

public class MyRunable implements Runnable {
    private String name;

    public MyRunable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("this Thread si "+Thread.currentThread().getName()+" Thread start : " + this.name + "     i=" + i);
        }
    }

}
