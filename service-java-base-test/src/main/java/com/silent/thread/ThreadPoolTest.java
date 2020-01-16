package com.silent.thread;



import java.util.*;
import java.util.concurrent.*;

/**
 * Author liutao
 * Date 2019/11/30 9:19 上午
 * Description:
 * Version: 1.0
 **/
public class ThreadPoolTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor= (ThreadPoolExecutor)Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<Future<String>>();
        Random random = new Random();
        for(int i=0;i<10;i++) {
            AnalysisExcel analysisExcel = new AnalysisExcel(String.valueOf(random.nextInt(10)));
            Future<String> result = threadPoolExecutor.submit(analysisExcel);

            resultList.add(result);
        }
        do{
            for (int i = 0; i < resultList.size(); i++) {
                Future<String> result = resultList.get(i);
                System.out.printf("Task %d : %s \n", i, result.isDone());
            }
             try{
                 TimeUnit.MILLISECONDS.sleep(50);
             }catch (Exception e){
                 e.printStackTrace();
             }
            System.out.println("=======================");
        }while (threadPoolExecutor.getCompletedTaskCount()<resultList.size());


        for(Future<String> string :resultList){
            System.out.println(string.get());
        }
        threadPoolExecutor.shutdown();


    }


}
