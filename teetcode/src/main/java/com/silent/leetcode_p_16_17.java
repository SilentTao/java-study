package com.silent;

/**
 * Author liutao
 * Date 2020/5/12 10:32 下午
 * Description:
 * Version: 1.0
 **/
public class leetcode_p_16_17 {

    public static void main(String[] args) {

    }


    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int b = nums[0];
        int max=b;

        for (int i = 1; i < nums.length; i++) {
                if(b<0){
                    b=nums[i];
                }else {
                    b=b+nums[i];
                }
                if(b>max){
                    max=b;
                }

        }


        return max;
    }

}
