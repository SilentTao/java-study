package com.silent.ioc;

import com.silent.bean.Student;
import org.springframework.beans.factory.BeanFactory;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Author liutao
 * Date 2020/5/14 9:26 上午
 * Description:
 * Version: 1.0
 **/
public class IocDemo {


    /**
     * 学习jndi  依赖拖拽, 两种方式进行依赖查找
     * @param args
     */
    public static void main(String[] args) {
        Student student;
        //依赖查找, 根据JNDI 实现
        try{
            Context ctx=new InitialContext();
            student=(Student)ctx.lookup("java:com/silent/bean/Student");
            student.setAge("23");
            student.setName("aaa");
            System.out.println(student.toString());

        }catch (Exception e){
            System.out.println(e);
        }
        //依赖拖拽



    }




}
