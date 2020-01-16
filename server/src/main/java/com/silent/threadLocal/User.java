package com.silent.threadLocal;

/**
 * Author liutao
 * Date 2019/12/12 10:25 上午
 * Description:
 * Version: 1.0
 **/
public class User {
    private String name;
    private String sex;

    User(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public void show(){
        System.out.println("show"+toString());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
