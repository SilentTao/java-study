package com.silent.base;

/**
 * \* User: silent
 * \* Date: 06/03/19 Time: 16:02
 * \* Description:
 * \
 */
public class BaseTest {

    public static void main(String[] args) {
        Object object=new Object();
       // object="123;

     /*  Integer bbb=(Integer)object;
      Integer ccc=(Integer)object;
        String aaa="2343";
        aaa.toString();
        Integer integer=Integer.valueOf(object.toString());
        System.out.println(integer);*/
       // System.out.println(object.toString());
        if(object instanceof Integer){
            System.out.println(object.toString());
        }
    }
}
