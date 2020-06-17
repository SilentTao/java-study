package com.silent.ioc.container;

import com.silent.bean.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Author liutao
 * Date 2020/5/15 10:17 上午
 * Description:
 * Version: 1.0
 *
 * @author liutao
 */
public class AnnotationApplicationContextIocDemo {


    public static void main(String[] args) {
        // c
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        //注册 AnnotationApplicationContextIocDemo.class
        annotationConfigApplicationContext.register(AnnotationApplicationContextIocDemo.class);
        annotationConfigApplicationContext.refresh();
        System.out.println(annotationConfigApplicationContext.getBean("Student"));
    }

    @Bean
    public Student Student() {
        Student student = new Student();
        student.setName("李云龙");
        student.setAge("23");
        return student;

    }

}
