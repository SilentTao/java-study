package concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author liutao
 * Date 2021/8/12 11:25 上午
 * Description:
 * 目标实现一个操作队列来减轻对于数据库读写的压力
 * Version: 1.0
 **/
public class QuqueTask {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadFactory factory= new  ThreadFactoryBuilder().setNameFormat("测试").build();
        //
        ExecutorService executorService=  new ThreadPoolExecutor(1,
                1,
                10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(50),// 设置低劣大小
                factory);
        List<FutureTask<String>>  list=new ArrayList<>();
        for(int i=0;i<20;i++) {
            int data=i;
            FutureTask<String> futureTask = new FutureTask<String>(() -> {
                TimeUnit.MILLISECONDS.sleep(1000);
                return "aaa"+data;
            });
            executorService.submit(futureTask);
            list.add(futureTask);
        }
        System.out.println("=======");
        for(FutureTask<String> futureTask:list){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(futureTask.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }

}
