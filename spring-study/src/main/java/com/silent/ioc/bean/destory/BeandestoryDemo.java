package com.silent.ioc.bean.destory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Author liutao
 * Date 2020/5/20 9:32 上午
 * Description:
 * Version: 1.0
 **/
public class BeandestoryDemo {

    @Component
    static class BeanDestoryTest {

        @Lazy
        @Bean(initMethod = "afterPropertiesSet", destroyMethod = "destory")
        void destructiveBean() {
        }
    }

}

