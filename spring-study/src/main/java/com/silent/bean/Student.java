package com.silent.bean;

/**
 * Author liutao
 * Date 2020/5/9 10:03 上午
 * Description:
 * Version: 1.0
 **/
public class Student {

    private String name;
    private String age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
