package com.silent.multithreading;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args)  {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> futureTask = executorService.submit(new MyCallable());
        if (!futureTask.isDone()) {
            System.out.println("task has not finished ,please wait!");
        }

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        finally {
            executorService.shutdown();

        }

    }
}
