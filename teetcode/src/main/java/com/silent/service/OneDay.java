package com.silent.service;

/**
 * Author liutao
 * Date 2019/12/25 1:18 下午
 * Description:
 * 两个有序数组 取中位数
 * Version: 1.0
 **/
public class OneDay {

    public static void main(String[] args) {

        double result;
        int[] a = {1, 2, 3, 4, 5, 6, 9};  //7个元素
        int[] b = {4, 6, 7, 8, 9};        //5个元素
        int countA = a.length;
        int countB = b.length;
        int ze = (countA + countB) % 2;
        System.out.println(ze);
        //第一种情况, a的末尾元素<b的开始元素
        if (a[a.length - 1] < b[0]) {    //
            if (ze == 0) {
                int flag = (countA + countB) / 2 - countA;
                if (flag < countA) {
                    result = (a[flag - 1] + a[flag - 2]) / 2;
                }
                if (flag == countA) {
                    result = (a[flag - 1] + b[0]) / 2;
                }
                if (flag > countA) {
                    result = (b[0] + b[1]) / 2;
                }
            } else {

            }

        }
        //第二种情况,b的末尾元素<a的开始元素

    }
}
