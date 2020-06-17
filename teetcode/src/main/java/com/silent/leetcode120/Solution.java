package com.silent.leetcode120;

import java.util.List;

/**
 * Author liutao
 * Date 2020/4/22 7:46 下午
 * Description:
 * Version: 1.0
 **/
public class Solution {

    /**
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     * <p>
     * 例如，给定三角形：
     * <p>
     * [
     * [2],
     * [3,4],
     * [6,5,7],
     * [4,1,8,3]
     * ]
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     * <p>
     * 说明：
     * <p>
     * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/triangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {


    }

    public int minimumTotal(List<List<Integer>> triangle) {
        /**
         * 处理特殊case
         */
        int min = Integer.MAX_VALUE;
        if (triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int size = triangle.size();
        int[][] dp = new int[size][size];
        //初始化值
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            int zi = triangle.get(i).size();
            for (int j = 0; j < zi; j++) {
                //最后一排开始选定最小值
                if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];
                } else if (j == zi - 1) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j - 1];
                } else {
                    int data1 = triangle.get(i).get(j) + dp[i - 1][j];
                    int data2 = triangle.get(i).get(j) + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(data1, data2);
                }
                if (i == size - 1) {
                    min = Math.min(min, dp[i][j]);
                }
            }
        }
        return min;

    }


}
