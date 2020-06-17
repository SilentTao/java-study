package com.silent;

import java.util.HashSet;
import java.util.Set;

/**
 * Author liutao
 * Date 2020/5/6 10:32 下午
 * Description:
 * Version: 1.0
 **/
public class leetcode_733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int chang=image.length;
        int kuang=image[0].length;
        int color = image[sr][sc];
        if (color != newColor) {
            dfs(image, sr, sc, color, newColor,chang,kuang);
        }
        return image;



    }

    /**
     * 从四个方向开始遍历, 如果碰到相同的则不进行深度变量了
     * @param image
     * @param r
     * @param c
     * @param color
     * @param newColor
     * @param chang
     * @param kuang
     */
    public void dfs(int[][] image, int r, int c, int color, int newColor,int chang ,int kuang) {
        //如果相等
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) {
                dfs(image, r - 1, c, color, newColor,chang,kuang);
            }
            if (c >= 1) {
                dfs(image, r, c-1, color, newColor,chang,kuang);
            }
            if (r+1 < chang){
                dfs(image, r+1, c, color, newColor,chang,kuang);
            }
            if (c+1 < kuang) {
                dfs(image, r, c+1, color, newColor,chang,kuang);
            }
        }


    }

    public static void main(String[] args) {
        Set<Integer> set=new HashSet<>();
        set.add(1);
        System.out.println(set.contains(1));
    }


}
