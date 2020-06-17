package com.silent.ioc.container;

import com.silent.bean.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * Author liutao
 * Date 2020/5/15 9:55 上午
 * Description:
 * Version: 1.0
 *
 * @author liutao
 */
public class BeanFactoryIocContainerDemo {
    public static void main(String[] args) {
        //初始化容器
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        // 创建 xml bean 装配器
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        int beansCount = xmlBeanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/dependncy-loopup-comtext.xml");
        System.out.println("被定义的bean的数量: " + beansCount);
        lookupBeanFactoryByType(defaultListableBeanFactory);



    }

    /**
     * 依赖查找到的方式获取beanr
     * @param beanFactory
     */
    private static void lookupBeanFactoryByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Student> map = listableBeanFactory.getBeansOfType(Student.class);
            System.out.println("依赖查找-类型查找: " + map.toString());

        }


    }
}
