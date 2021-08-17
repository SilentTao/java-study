package concurrent;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @author liutao
 * Date 2021/8/17 5:44 下午
 * Description:
 * Version: 1.0
 **/
public class ThreadLocalTest {
    public static void main(String[] args) {
        TransmittableThreadLocal<String> transmittableThreadLocal=new TransmittableThreadLocal<>();

        /**
         * 通过重childrenValue()方法进行
         */
        InheritableThreadLocal<String>  inheritableThreadLocal=new InheritableThreadLocal<>();

        ThreadLocal<String> threadLocal=new ThreadLocal<>();

    }
}
