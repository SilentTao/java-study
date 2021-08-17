package concurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author liutao
 * Date 2021/7/19 7:46 下午
 * Description: 线程协同操作demo
 *  countDownLatch
 *  CyclicBarrier
 * Version: 1.0
 **/
public class ThreadSynDemo {



    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        ThreadFactory threadFactory=new ThreadFactory() {
             AtomicLong count =  new AtomicLong(0) ;
            @Override
            public Thread newThread(Runnable r) {
                Thread thread=new Thread(r);
                thread.setName("线程池线程"+count);
                count.incrementAndGet();
                System.out.println("创建了 线程池线程 "+count);
                return  thread;
            }
        };
        ThreadPoolExecutor threadPoolExecutor= new ThreadPoolExecutor(3,4,100, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(1000),threadFactory);

        CountDownLatch countDownLatch=new CountDownLatch(3);
        threadPoolExecutor.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(2L);
                System.out.println("任务一开始...");
                countDownLatch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(2L);
                System.out.println("任务二开始...");
                countDownLatch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(1L);
                System.out.println("任务三开始...");
                countDownLatch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        countDownLatch.await();
        System.out.println("三个任务都完成...");

        CyclicBarrier cyclicBarrier=new CyclicBarrier(3);

        threadPoolExecutor.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(2L);
                System.out.println("一开始...");
                cyclicBarrier.await();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(2L);
                System.out.println("二开始...");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        cyclicBarrier.await();
        System.out.println("都完成了");


    }





}
