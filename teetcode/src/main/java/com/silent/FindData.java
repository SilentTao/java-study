package com.silent;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liutao
 * Date 2021/3/12 10:49 上午
 * Description:
 * <p>
 * 原描述：
 * 给出一个元素无序的数组，求出一个数，使得其左边的数都小于它，右边的数都大于等于它。
 * 要求时间复杂度n
 * <p>
 * 整理及丰富细节：
 * 一个无序的数组，找出所有符合以下特点的数，返回它们的索引。
 * 这个数的左边的数都小于它，右边的数都大于等于它。
 * 要求时间复杂度 O(n) 。
 * <p>
 * Version: 1.0
 **/
public class FindData {

    public static void main(String[] args) {
        int[] arr4 = {2,1, 3, 4, 7,9,8};

        System.out.println(findMaxAndMiniByStack(arr4));

        System.out.println(findMaxAndMini(arr4));
    }


    private static List<Integer> find(int[] data) {
        if (data.length < 3) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < data.length; i++) {
            if (data[i - 1] > data[i - 2] && data[i] > data[i - 1]) {
                list.add(data[i - 1]);
            }
        }
        return list;
    }

    /**
     * 查表法
     * <p>
     * 2  23   45   38   67  90
     *
     * @param data
     * @return
     */
    private static List<Integer> findMaxAndMini(int[] data) {
        List<Integer> list = new ArrayList<>();
        if (data.length < 3) {
            return new ArrayList<>();
        }

        if (data.length == 3) {
            if (data[1] > data[0] && data[2] > data[1]) {
                list.add(data[1]);
            }
            return list;
        }
        int[] minData = new int[data.length];
        int mini = data[data.length - 1];
        for (int i = data.length - 1; i >= 0; i--) {
            if (data[i] <= mini) {
                minData[i] = 1;
                mini = data[i];
            } else {
                minData[i] = 0;
            }
        }


        int[] maxData = new int[data.length];
        int max = data[0];
        for (int i = 0; i < data.length; i++) {
            if (data[i] >= max) {
                maxData[i] = 1;
                max = data[i];
            } else {
                maxData[i] = 0;
            }
        }

        for (int i = 1; i < data.length-1; i++) {
            if (maxData[i] + minData[i] == 2) {
                list.add(data[i]);
            }
        }
        return list;
    }

    /**
     * @param data
     * @return
     */
    private static Stack<Integer> findMaxAndMiniByStack(int[] data) {
        Stack<Integer> stack = new Stack<>();
        if (data.length < 3) {
            return stack;
        }
        int max = data[0];
        for (int i = 1; i < data.length ; i++) {
            //移出前边比我大的,那么就
            while (!stack.empty() && stack.peek() > data[i]) {
                stack.pop();
            }

            if (data[i] > max) {
                stack.push(data[i]);
            }

            max = Math.max(max, data[i]);
        }
        return stack;
    }


    /**
     * // 给定整形数组，对于每个元素，查找比当前元素大的右边第一个元素。input=[10,1,4,19,20] res=[19,4,19,20,-1]
     */

    private static int[] findRightMaxStack(int[] data) {


        return null;
    }

}
