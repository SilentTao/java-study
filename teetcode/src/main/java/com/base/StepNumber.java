package com.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liutao
 * Date 2021/6/28 5:08 下午
 * Description:
 * Version: 1.0
 **/
public class StepNumber {

    public static void main(StringTest[] args) {
        int step = 0;
        int[] steps = new int[]{1, 1, 1, 1, 1, 1};

        System.out.println(findStep(steps));
    }

    /**
     * 动态规划做
     *
     * @param steps
     * @return
     */
    private static int findStep(int[] steps) {
        List<Integer> result = new ArrayList<>();
        int size = steps.length;
        //初始化二维数组
        int[][] map = new int[size][size];
        //循环构建数组
        for (int i = 0; i < size; i++) {
            int value = (steps[i] +1> size - i ? size : steps[i]+1);
            System.out.println(value);
            for (int j = i; j < value; j++) {
                map[i][j] = 1;
            }
        }
        printMap(map);
        //当前所在指针
        int stepPoint = size - 1;
        //寻找行数
        int findRows = size - 1;

        while (stepPoint > 0) {
            System.out.println("step==" + stepPoint);
            //寻找列数
            int findLast = 0;
            while (findLast < size) {
                if (map[findLast][findRows] == 1) {
                    stepPoint = findLast;
                    findRows = findLast;
                    result.add(stepPoint);
                    System.out.println("走出一步到: " + findLast);
                    break;
                }
                findLast++;
            }
        }
        System.out.println(result);
        return result.size()-1;

    }


    private static void printMap(int[][] map) {
        int size = map[0].length;
        for (int i = 0; i < size; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j < size; j++) {
                stringBuffer.append(" " + map[i][j]);
            }
            System.out.println(stringBuffer.toString());
        }
    }

}
