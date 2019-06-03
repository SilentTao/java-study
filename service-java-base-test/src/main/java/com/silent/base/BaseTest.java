package com.silent.base;

/**
 * \* User: silent
 * \* Date: 06/03/19 Time: 16:02
 * \* Description:
 * \
 */
public class BaseTest {

    public static void main(String[] args) {
      //  Object object=new Object();
       // object="123;

     /*  Integer bbb=(Integer)object;
      Integer ccc=(Integer)object;
        String aaa="2343";
        aaa.toString();
        Integer integer=Integer.valueOf(object.toString());
        System.out.println(integer);*/
       // System.out.println(object.toString());
    /*    if(object instanceof Integer){
            System.out.println(object.toString());
        }*/

        int a=0;
        a=4^4;
        int[] aaa={1,1,3,3,2,4,4};
        System.out.println(a);
        for (int i=0;i< aaa.length-1;i=i+2){
            int yihuo=aaa[i]^aaa[i+1];
            if(yihuo!=0){
                System.out.println(aaa[i] +"is dang shu ");
            }
            System.out.println("位置:"+i+"　位置:"+(i+1)+"结果:"+yihuo);
        }
    }
}
