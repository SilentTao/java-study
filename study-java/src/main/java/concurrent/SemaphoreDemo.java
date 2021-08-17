package concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.checkerframework.checker.units.qual.Time;

import java.util.concurrent.*;

/**
 * @author liutao
 * Date 2021/7/29 5:08 下午
 * Description: semaphore 示例
 * Version: 1.0
 **/
public class SemaphoreDemo {

    public static void main(String[] args) {
        new SemaphoreDemo().stopArea();
    }

    /**
     * 模拟实现停车场
     * 假设停车场有10个车位
     * semaphore
     *
     *
     */
    public void stopArea(){
        Semaphore semaphore=new Semaphore(5);
        ThreadFactory factory=new  ThreadFactoryBuilder().setNameFormat("线程数").build();
        ThreadPoolExecutor executorService= new ThreadPoolExecutor(34,100,10,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(1000),factory);

        for (int i=1;i<30;i++){
             int  index=i;
            executorService.execute(()->{

                try {
                    if(semaphore.availablePermits()==0){
                        System.out.println("车位不足，车0"+index+"请耐心等待");
                    }
                    semaphore.acquire();
                    System.out.println("========汽车代号0"+ index +"入场成功");
                    TimeUnit.MILLISECONDS.sleep(1000);

                    System.out.println("汽车代号0"+ index +"出场成功");
                    semaphore.release();
                } catch (InterruptedException e) {

                }

            });
        }
        for (int i=31;i<40;i++){
            int  index=i;
            executorService.execute(()->{

                try {
                    if(semaphore.availablePermits()==0){
                        System.out.println("车位不足，车0"+index+"请耐心等待");
                    }
                  if(semaphore.tryAcquire(2,TimeUnit.SECONDS)){
                      System.out.println("========汽车代号0"+ index +"入场成功");
                      TimeUnit.MILLISECONDS.sleep(2000);

                      System.out.println("汽车代号0"+ index +"出场成功");
                      semaphore.release();
                  }else {
                      System.out.println("汽车代号0"+ index +"等了1秒,没有车位离开了------");
                  }


                } catch (InterruptedException e) {

                }

            });
        }


    }
}
