package com.silent.ioc.bean;

import com.silent.bean.Student;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;

/**
 * Author liutao
 * Date 2020/5/18 9:35 上午
 * Description:
 * Version: 1.0
 *
 * @author liutao*/
public class BeanDefinitionCreationDemo {


    public static void main(String[] args) {

        BeanDefinitionBuilder beanDefinitionBuilder= BeanDefinitionBuilder.genericBeanDefinition(Student.class);

        beanDefinitionBuilder.addPropertyValue("name","m阿轲");
        beanDefinitionBuilder.addPropertyValue("age","123");

        BeanDefinition definition=beanDefinitionBuilder.getBeanDefinition();

        System.out.println("bean的名称"+definition.getBeanClassName());



    }

}
