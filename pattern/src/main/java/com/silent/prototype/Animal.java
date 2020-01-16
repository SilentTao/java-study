package com.silent.prototype;

/**
 * Author liutao
 * Date 2019/12/3 10:13 上午
 * Description:
 * Version: 1.0
 **/
public class Animal implements Cloneable {


    private String name;
    private String country;
    private String age;
    private String sex;  // 雌/雄

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object object = null;
        try {
            object = super.clone();

        } catch (CloneNotSupportedException e) {
            System.out.println("clone error");

        }
        return object;
    }
}
