package com.silent.service;

import com.silent.bean.Student;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * Author liutao
 * Date 2020/5/13 10:04 上午
 * {@link com.silent.bean.Student}
 * 类型变化转换
 * Description:
 * Version: 1.0
 **/
public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Student.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            //  System.out.println(propertyDescriptor.toString());
            //        PropertyEditor
            Class<?> properType = propertyDescriptor.getPropertyType();
            String properName = propertyDescriptor.getName();
            if ("age".equals(properName)) {
                propertyDescriptor.setPropertyEditorClass(stringToIntegerPropertyEditor.class);
            }
              System.out.println(propertyDescriptor.toString());
        });


    }

    private class stringToIntegerPropertyEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) {
            Integer data = Integer.valueOf(text);
            setValue(data);

        }


    }


}
