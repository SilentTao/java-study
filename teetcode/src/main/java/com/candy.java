package com;

/**
 * @author liutao
 * Date 2021/7/17 5:59 下午
 * Description:
 * Version: 1.0
 **/
public class candy {

    public int candy(int[] ratings) {
        int nums = ratings.length;
        //处理小于三人的情况
        if (nums == 0) {
            return 0;
        }
        if (nums == 1) {
            return 1;
        }
        if (nums == 2) {
            return 3;
        }
        //创建糖果数组
        int[] initCandy = new int[nums];
        //init prize candy
        for (int i = 0; i < nums; i++) {
            initCandy[i] = 1;
        }
        for (int i = 1; i < nums; i++) {
            if (ratings[i] > ratings[i - 1]) {
                initCandy[i] = initCandy[i - 1] + 1;
            }
        }
        for (int i = nums - 2; i >=0; i--) {
            if (ratings[i] > ratings[i +1]) {
                initCandy[i] = Math.max(initCandy[i],initCandy[i+1]+1);
            }
        }
        int candyNums = 0;
        for (int i = 0; i < nums; i++) {
            candyNums = candyNums + initCandy[i];
        }
        return candyNums;
    }

}
