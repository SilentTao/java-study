package com.silent;

/**
 * @author liutao
 * Date 2020/7/8 11:16 下午
 * Description:
 * 背包问题
 * Version: 1.0
 **/
public class knapsackProblem {

    public static void main(String[] args) {
        int m = 10;
        int n = 3;
        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
        int c[][] = BackPack_Solution(m, n, w, p);
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                System.out.print(c[i][j]+"\t");
                if(j==m){
                    System.out.println();
                }
            }
        }
    }


    /**
     * 给定一组多个（[公式]）物品，
     * 每种物品都有自己的重量（[公式]）和价值（[公式]），
     * 在限定的总重量/总容量（[公式]）内，
     * 选择其中若干个（也即每种物品可以选0个或1个），设计选择方案使得物品的总价值最高。
     *
     * @param maxSize 表示背包的最大容量
     * @param count 表示商品个数
     * @param weightNms 表示商品重量数组
     * @param pricesNums 表示商品价值数组
     */
    public static int[][] BackPack_Solution(int maxSize, int count, int[] weightNms, int[] pricesNums) {
        //data[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int[][] data = new int[count + 1][maxSize + 1];

        // 初始化值
        for (int i = 0; i < count + 1; i++) {
            data[i][0] = 0;
        }
        for (int j = 0; j < maxSize + 1; j++) {
            data[0][j] = 0;
        }

        for (int i = 1; i < count + 1; i++) {
            for (int j = 1; j < maxSize + 1; j++) {
                if (weightNms[i - 1] <= j) {
                    data[i][j] = Math.max(data[i - 1][j], (data[i - 1][j - weightNms[i - 1]] + pricesNums[i - 1]));
                } else {
                    data[i][j] = data[i - 1][j];
                }
            }
        }
        return data;
    }


}
