package com.silent.leetcode06;

/**
 * Author liutao
 * Date 2020/1/25 5:09 下午
 * Description:
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *LCODEIRINETIHGES
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * Version: 1.0
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(4%4);
        String aaa = "LEETCODEISHIRING";
        System.out.println(new Solution().convert(aaa, 3));
    }

    public String convert(String s, int numRows) {
        String result = "";
        //如果行数为1, 则放回原字符串
        if (numRows == 1) {
            return s;
        }
        String[] sList = new String[numRows];
        int lie = numRows;
        int xie = 2 * numRows - 2;
        int lunxun = lie + xie;
        System.out.println(lunxun);
        //从0开始
        char[] chars = s.toCharArray();
        for (int i = 1; i <= chars.length; i++) {
            int yushu = i % lunxun;
            System.out.println("i is " + i + " yushu is " + yushu);
            if(yushu==0){
//                if(sList[0]==null){
//                    sList[0]="";
//                }
                sList[0] = sList[0] + chars[i - 1];
                continue;
            }

            if (yushu > lie) {
//                if(sList[yushu - 1]==null){
//                    sList[yushu - 1]="";
//                }
                int xiaoYuShu = 2 * numRows - yushu; //存储偏移量
                System.out.println("xiaoYuShu is " + xiaoYuShu);
                if (xiaoYuShu == 0) {
                    sList[0] = sList[0] + chars[i - 1];
                    continue;
                }
                sList[xiaoYuShu - 1] = sList[xiaoYuShu - 1] + chars[i - 1];
            } else {
//                if(sList[yushu - 1]==null){
//                    sList[yushu - 1]="";
//                }
                sList[yushu - 1] = sList[yushu - 1] + chars[i - 1];
            }
        }
        //拼接字符串
        for (int i = 0; i < sList.length; i++) {
            result = result + sList[i];
        }

        return result;
    }


}
