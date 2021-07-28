package com.silent.jvm.memory;

/**
 * @author liutao
 * Date 2021/7/1 4:29 下午
 * Description:
 * Version: 1.0
 **/
public class Node {

    private String name;

    private int age;

    private String  value;

    public  Node(){

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
