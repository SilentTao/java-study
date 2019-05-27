package com.silent.sort;

public class InsertionSort {


    public static void main(String[] args) {

        int[] insertionSort = {3, 2, 49, 8, 1, 0, 23, 4, 5, 90};
        for (int j = 1; j < insertionSort.length; j++) {
            int value = insertionSort[j]; //2
            //插入的位置
            int insertFlag = j - 1;  //0   insertionSort[0]=3
            for (; insertFlag >= 0; --insertFlag) {
                if (insertionSort[insertFlag] > value) {
                    //insertionSort[1]= insertionSort[0] --->insertionSort[1]==3 ,insertionSort[0]=3
                    insertionSort[insertFlag + 1] = insertionSort[insertFlag];
                } else {
                    //跳出当前数据交换的循环  直接复制
                    break;
                }
            }
            // inserFlag==-1
            insertionSort[insertFlag + 1] = value; // 1 ==3
        }

        for (int j = 0; j < insertionSort.length; j++) {
            System.out.print(insertionSort[j] + " ");
        }
    }

}
