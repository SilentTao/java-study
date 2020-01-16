package com.silent.factory;

/**
 * Author liutao
 * Date 2019/12/3 9:47 上午
 * Description:
 * Version: 1.0
 **/
public abstract class Animal implements Cloneable {


    private String name;
    private String country;
    private String age;
    private String sex;  // 雌/雄


    public void eat() {
    }
    // 重些 clone
    @Override
    protected Object clone()  {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
