package com.silent.leetcode;

import java.util.HashMap;

/**
 * \* User: silent
 * \* Date: 15/03/19 Time: 11:53
 * \* Description:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * \
 */
public class TwoSumTask {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] location = twoSum(nums, 6);
        System.out.println("[" + location[0] + "," + location[1] + "]");
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] location = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>(10);
        for (int i = 0; i < nums.length; i++) {

            int mapKey = target - nums[i];
            if (hashMap.get(mapKey) != null ) {
                if (i > hashMap.get(mapKey)) {
                    location[0] = hashMap.get(mapKey);
                    location[1] = i;
                } else {
                    location[0] = i;
                    location[1] = hashMap.get(mapKey);
                }
                break;
            }
            hashMap.put(nums[i], i);
        }
        return location;
    }
}
