package com.silent.sort;

public class BubbleSort {

    // 冒泡排序的时间复杂度为
    public static void main(String[] args) {
        int changeData;
        int[] bubbleSort = {2, 3, 49, 8, 1, 0, 23, 4, 5, 90};

        for (int j = 0; j < bubbleSort.length; j++) {
            boolean flag = false;
            for (int i = 0; i < bubbleSort.length - j - 1; i++) {
                if (bubbleSort[i] > bubbleSort[i + 1]) {
                    changeData = bubbleSort[i];
                    bubbleSort[i] = bubbleSort[i + 1];
                    bubbleSort[i + 1] = changeData;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        for (int j = 0; j < bubbleSort.length; j++) {
            System.out.print(bubbleSort[j] + " ");
        }
    }

}
