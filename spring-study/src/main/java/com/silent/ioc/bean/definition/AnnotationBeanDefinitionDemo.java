package com.silent.ioc.bean.definition;

import com.silent.bean.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author liutao
 * Date 2020/5/19 9:40 上午
 * Description:
 * Version: 1.0
 **/
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(AnnotationBeanDefinitionDemo.class);


        annotationConfigApplicationContext.refresh();

        String[] studens=annotationConfigApplicationContext.getBeanNamesForType(Student.class);
        for(String name:studens){
            System.out.println(name);
        }
        System.out.println("根据类型查询出所有的bean" + annotationConfigApplicationContext.getBeansOfType(Student.class).toString());

        annotationConfigApplicationContext.close();
    }


    @Bean(name = {"studenA"})
    public Student student() {
        Student student = new Student();
        student.setAge("studenA");
        student.setName("studenA");
        return student;
    }

    @Bean(name = {"studenB"})
    public Student student1() {
        Student student = new Student();
        student.setAge("studenB");
        student.setName("studenB");
        return student;
    }
}
