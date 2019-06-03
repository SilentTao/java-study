package com.silent.leetcode;

public class ArrayRotate {

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        if (k == 0 || k == length) {
            return;
        }

        int changeTimes = 0;
        if (length > k) {
            changeTimes = length - k;
        } else {
            changeTimes = length - (k % length);
        }
        for (int i = 0; i < changeTimes; i++) {
            int tag = nums[0];
            for (int j = 1; j < length; ++j) {
                nums[j - 1] = nums[j];
            }
            nums[length - 1] = tag;
        }
    }

    public static void main(String[] args) {
        int[] aaa = {1, 2, 3};
        rotate(aaa, 4);
        for (int i = 0; i < aaa.length; i++) {
            System.out.println(aaa[i]);
        }
    }
}
