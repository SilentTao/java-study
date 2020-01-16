package com.silent.leetcode01;

import java.util.HashMap;

/**
 * Author liutao
 * Date 2020/1/14 8:54 下午
 * Description:  求两数之和
 * Version: 1.0
 **/
public class Solution {


    public static void main(String[] args) {
        int[] ccc={1,2,9,3};

        int[] number=twoSum(ccc,3);
        System.out.println(number[0]+" "+number[1]);
    }


    public static int[] twoSum(int[] nums, int target) {
        int[] tow = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int number = target - nums[i];
            if (map.containsKey(number)) {
                tow[0] = i;
                tow[1] = map.get(number);
            }
            map.put(nums[i], i);
        }
        return tow;
    }


}
