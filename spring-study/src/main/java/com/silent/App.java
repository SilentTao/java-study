package com.silent;

import com.silent.bean.ParentService;
import com.silent.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
        Student car2 = (Student) applicationContext.getBean("car2");
        System.out.println("applicationContext displayName: "+applicationContext.getDisplayName());
        System.out.println("applicationContext parent: "+applicationContext.getParent());
        System.out.println("applicationContext  definitnames: "+applicationContext.getBeanDefinitionNames().toString());

        System.out.println(car2.getAge() + " name : " + car2.getName());
        System.out.println("Hello World!");

        GenericApplicationContext applicationContext1=new AnnotationConfigApplicationContext(ParentService.class);
        Map<String,ParentService> beans    =   applicationContext1.getBeansOfType(ParentService.class);

        beans .entrySet().stream().forEach(b ->{
            System.out.println("key is "+ b.getKey() + "  values is "+b.getValue().soutName());
        });

    }
}
