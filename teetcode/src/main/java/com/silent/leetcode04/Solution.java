package com.silent.leetcode04;

/**
 * Author liutao
 * Date 2020/1/15 7:41 下午
 * Description:
 * Version: 1.0
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution {
     int[] lingshi;
     int[] longSum;
     int[] shortSum;
     int lingshiIndex = 0;
     int countlingshi = 0;
    //短链游标
     int sumshortIndex = 0;

    public  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum1Size = nums1.length;
        int sum2Size = nums2.length;
        int sumlenght = sum1Size + sum2Size;
        boolean out = (sumlenght % 2 == 0); // 真为偶数,假为
        int zhongweishuIndex = sumlenght / 2;
        int leftIndex = out ? zhongweishuIndex - 1 : zhongweishuIndex;
        int rightIndex = zhongweishuIndex;
        // System.out.println("leftIndex "+leftIndex+" rightIndex "+rightIndex);

        // 处理常规情况
        lingshi = new int[sumlenght+10];

        longSum = sum1Size > sum2Size ? nums1 : nums2;
        shortSum = sum1Size > sum2Size ? nums2 : nums1;
        if(sum1Size==sum2Size){
            if(nums1[nums1.length/2]<=nums2[nums2.length/2]){
                longSum=nums2;
                shortSum=nums1;
            }else {
                longSum=nums1;
                shortSum=nums2;
            }
        }
        for (int i = 0; i < longSum.length; i++) {
            //如果已经跑到中位数附近则跳出循环
            if (countlingshi > rightIndex + 2) {
                break;
            }
            if (sumshortIndex > shortSum.length - 1) {
                lingshi[lingshiIndex] = longSum[i];
                lingshiIndex++;
                countlingshi++;
                continue;
            }
            //System.out.println("外部  shortData is "+shortSum[sumshortIndex]+"longSumData is "+longSum[i] );

            if (shortSum[sumshortIndex] < longSum[i]) {
                //  System.out.println("<<  shortData is "+shortSum[sumshortIndex]+"longSumData is "+longSum[i] );
                move(longSum[i]);

            }
            // 递归循环出来执行的判断,如果短链已经跑完了, 则布跑短链了.
            if (sumshortIndex > shortSum.length - 1) {
                lingshi[lingshiIndex] = longSum[i];
                lingshiIndex++;
                countlingshi++;
                continue;
            }
            //
            if (shortSum[sumshortIndex] > longSum[i]) {
                // System.out.println(">>  shortData is "+shortSum[sumshortIndex]+"longSumData is "+longSum[i] );
                lingshi[lingshiIndex] = longSum[i];
                lingshiIndex++;
                countlingshi++;
                continue;
            }

            if (shortSum[sumshortIndex] == longSum[i]) {
                // System.out.println("==  shortData is "+shortSum[sumshortIndex]+"longSumData is "+longSum[i] );
                lingshi[lingshiIndex] = longSum[i];
                lingshiIndex++;
                countlingshi++;
                lingshi[lingshiIndex] = shortSum[sumshortIndex];
                lingshiIndex++;
                countlingshi++;
                sumshortIndex++;
            }
        }
//        for (int a:lingshi) {
//            System.out.println(a+",");
//
//        }
//        System.out.println("中位数");
        return ((double) lingshi[leftIndex] + (double) lingshi[rightIndex]) / 2;
    }

    private  void move(int iData) {
//        System.out.println("****");
//        System.out.println("lingshiIndex:"+lingshiIndex+" countlingshi:"+countlingshi +" iData: "+iData+" sumshortIndex: "+sumshortIndex+"  rightIndex:"+rightIndex);
//        System.out.println("shortData is "+shortSum[sumshortIndex]);
        //如果短链都处理完了跳出循环

        lingshi[lingshiIndex] = shortSum[sumshortIndex];
        sumshortIndex++; // 短链指针品偏移

        countlingshi++;  // 总数偏移
        lingshiIndex++;  //临时指针偏移
        //  System.out.println("****");
        //递归实现
        if (sumshortIndex < shortSum.length && shortSum[sumshortIndex] < iData) {
            // System.out.println("递归: shortData is "+shortSum[sumshortIndex]);

            move(iData);
        }
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};  //7个元素
        int[] b = {4, 6, 7, 8, 9};        //5个元素

        int[] nums1 = {1, 2};
        int[] nums2 = {3,4};
        System.out.println( new Solution().findMedianSortedArrays(nums1, nums2));
    }

}
