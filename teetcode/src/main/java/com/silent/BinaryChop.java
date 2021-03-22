package com.silent;

/**
 * @author liutao
 * Date 2020/7/2 10:07 下午
 * Description:
 * <p>
 * 二分查找
 * <p>
 * Version: 1.0
 **/
public class BinaryChop {


    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 3, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("find last is "+findLastNumber(nums, 3));
        System.out.println("find first is "+findFirstNumber(nums, 3));

    }


    /**
     * 普通的二分查找
     * 给定一个有序数据 int[] a ={1,2,3,4,5,6,7,99,1000,223232};
     */
    public static int GeneraBinaryChop(int[] nums, int target) {

        int left = 0;
        int right = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找, 找出有序数组给出的数据的重复数据最后一次出现的位置
     * int[] a ={1,2,3,4,5,6,7,99,1000,223232}
     */
    public static int findLastNumber(int[] nums, int target) {

        int left = 0;
        int numsLength = nums.length - 1;
        int right = numsLength;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid == numsLength) {
                    return mid;
                } else {
                    //处理当前获取的目标值非最后一个的情况
                    if (nums[mid + 1] == target) {
                        left = mid + 1;
                    } else {
                        return mid;
                    }
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找, 找出有序数组给出的数据的重复数据第一次出现的位置
     * int[] a ={1,2,3,4,5,6,7,99,1000,223232}
     */
    public static int findFirstNumber(int[] nums, int target) {

        int left = 0;
        int numsLength = nums.length - 1;
        int right = numsLength;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                if (mid == 0) {
                    return mid;
                } else {
                    //处理当前获取的目标值非最后一个的情况
                    if (nums[mid - 1] == target) {
                        right = mid - 1;
                    } else {
                        return mid;
                    }
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
