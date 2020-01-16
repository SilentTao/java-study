package com.silent.threadLocal;

/**
 * Author liutao
 * Date 2019/12/13 1:03 下午
 * Description:
 * Version: 1.0
 **/
public class UserTask implements Runnable
{
    private ThreadLocal threadLocal;
    private String name;

    public UserTask(ThreadLocal threadLocal,String name){
        this.threadLocal=threadLocal;
        this.name=name;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++)
        {
            System.out.println("打印 thradLocal");
            // ThreadLocal.get方法获取线程变量
            if(null == threadLocal.get())
            {
                // ThreadLocal.et方法设置线程变量
                threadLocal.set(0);
                System.out.println("线程" + name + ": 0");
            }
            else
            {
                int num = (Integer)threadLocal.get();
                threadLocal.set(num + 1);
                System.out.println("线程" + name + ": " + threadLocal.get());
                if(i == 3)
                {
                    threadLocal.remove();
                }
            }
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }


    }
}
