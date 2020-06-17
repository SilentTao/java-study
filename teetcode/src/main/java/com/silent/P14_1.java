package com.silent;

/**
 * Author liutao
 * Date 2020/5/19 10:34 下午
 * Description:
 * Version: 1.0
 **/
public class P14_1 {

    public static void main(String[] args) {

        System.out.println(new P14_1().cuttingRope1(5));

    }


    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = 2 * dp[i - 2] > 3 * dp[i - 3] ? 2 * dp[i - 2] : 3 * dp[i - 3];
        }
        return dp[n];

    }

    /**
     * 递归计算,超时
     *
     * @param n
     * @return
     */
    public int cuttingRope1(int n) {
        if (n == 2) {
            return 1;
        }
        return cutting(n);

    }

    public Integer cutting(int n) {
        int res = -1;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.max(cutting(n - i) * i, i * (n - i)));
        }
        return res;
    }


}
