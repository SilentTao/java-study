package com.silent.base;

public class StringTest {

    public static void main(String[] args) {
        String aaa = "1232";
        //创建了两个对象，一个是在字符串常量池中，一个是在heap中
        String bbb = new String("1232");
        // intern 关键字取值去的是字符串常量池中的值
        String ccc = aaa.intern();
        System.out.println(aaa.indexOf("2"));

        System.out.println(aaa == bbb);
        System.out.println(bbb == ccc);
        System.out.println(aaa == ccc);


    }


}
