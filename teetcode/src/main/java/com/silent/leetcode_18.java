package com.silent;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Author liutao
 * Date 2020/6/16 7:48 下午
 * Description:
 * Version: 1.0
 **/
public class leetcode_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        // 排序
        Arrays.sort(nums);

        int len =  nums.length - 3;

        for (int i = 0; i < len; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = nums.length - 1; j > i + 1; j--) {
                int L = i + 1;
                int R = j - 1;
                while (R > L) {
                    int sum = nums[i] + nums[L] + nums[R] + nums[j];
                    if (sum == target) {
                        // 由于尾指针去重不了，所以加了一层校验，这一块待优化
                        List<Integer> list = Arrays.asList(nums[i], nums[L], nums[R], nums[j]);
                        if (!result.contains(list)) {
                            result.add(list);
                        }
                        while (R > L && nums[R - 1] == nums[R]) {
                            R--; // 去重
                        }
                        while (R > L && nums[L + 1] == nums[L]) {
                            L++; // 去重
                        }
                        L++;
                        R--;
                    }
                    if (sum > target) {
                        R--;
                    }
                    if (sum < target) {
                        L++;
                    }
                }
            }
        }
        return result;

    }
}
