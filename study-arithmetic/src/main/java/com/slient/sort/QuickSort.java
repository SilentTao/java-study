package com.slient.sort;

/**
 * @author liutao
 * Date 2021/8/12 2:19 下午
 * Description: 快速排序
 * Version: 1.0
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] sortNums = {93, 4, 1, 5, 8, 3, 2};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(sortNums, 0, sortNums.length - 1);
        for (int i = 0; i < sortNums.length; i++) {
            System.out.println(sortNums[i]);
        }
    }
    private void quickSort(int[] sortNums, int start, int end) {
        if (start >= end) {
            return;
        }
        int checkpoint = patition(sortNums, start, end);
        //向左
        quickSort(sortNums, start, checkpoint - 1);
        //向右
        quickSort(sortNums, checkpoint + 1, end);
    }

    private int patition(int[] sortNums, int start, int end) {

        int data = sortNums[start];
        int left = start;
        int right = end;
        while (left < right) {
            //从右向左找第一个小于
            while (sortNums[right] >= data && left < right) {
                right--;
            }
            //从左向右找第一个大于的基数
            while (sortNums[left] <= data && left < right) {
                left++;
            }

            swap(sortNums, left, right);
        }
        swap(sortNums, start, left);
        return left;
    }

    private void swap(int[] n, int start, int end) {
        int temp = n[start];
        n[start] = n[end];
        n[end] = temp;
    }


}
