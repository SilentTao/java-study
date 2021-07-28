package com.silent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.silent"})
public class BaseApplication {


    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }
}
