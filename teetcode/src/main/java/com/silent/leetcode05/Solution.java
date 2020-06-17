package com.silent.leetcode05;

/**
 * Author liutao
 * Date 2020/1/19 6:08 下午
 * Description:
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Version: 1.0
 **/
public class Solution {

    int length;
    char[] array;
    boolean isRight;
    int huiwenLenth = 0;
    String huiwen = "";
    boolean oushuB = false;



    public String longestPalindrome(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s;
        }
        //设置回文计数
        huiwenLenth = 0;

        //设置字符串长度
        length = s.length();
        array = s.toCharArray();
        huiwen = huiwen + array[0];
        // 游标初始化为0
        int flag = 0;
        int expansionIndex = 1;
        int oushuindex = 0;
        for (int i = 0; i < array.length; i++) {
            isRight = true; // 第一次判断会单独判断下加上相邻的第一个数是否相同,即为回文
            //奇 处理
            isjishuHuiwen(flag, expansionIndex);
            //偶 处理
            oushuHuiwen(flag, oushuindex);
            //处理完后重置标识
            expansionIndex = 1;
            oushuindex = 1;
            flag++;
        }


        return huiwen;
    }

    /**
     * 边界条件, 第一步先求出
     * 奇数
     *
     * @param flag
     * @param expansionIndex
     * @return
     */
    private void isjishuHuiwen(int flag, int expansionIndex) {
//        System.out.println("flag " + flag + " first: " + (flag - expansionIndex) + " end: " + (flag + expansionIndex));
        //开始左右向外扩 , 奇数情况
        if (flag - expansionIndex >= 0
                && expansionIndex + flag < length
                && array[flag - expansionIndex] == array[flag + expansionIndex]
        ) {
            if (expansionIndex * 2 + 1 > huiwenLenth) {
                String isHuiwen = getString(flag - expansionIndex, flag + expansionIndex);
               // System.out.println("奇数回文为: " + isHuiwen);
                if (isHuiwen.length() > huiwenLenth) {
                    huiwenLenth = isHuiwen.length();
                    huiwen = isHuiwen;
                }
            }
            int nextExpansionIndex = expansionIndex + 1;
            isjishuHuiwen(flag, nextExpansionIndex);
        }
    }

    private void oushuHuiwen(int flag, int oushuindex) {
        int minFlag = flag - 2 * oushuindex + 1;
        //最大索引没有越界
        if (minFlag >= 0) {
            oushuB = false;
            oushu(flag, 0, minFlag, oushuindex);
            if (oushuB) {
                String isHuiwen = getString(minFlag, flag);
              //  System.out.println("偶数回文为: " + isHuiwen);
                if (isHuiwen.length() > huiwenLenth) {
                    huiwenLenth = isHuiwen.length();
                    huiwen = isHuiwen;
                }
            }
            int nexoushuindex = oushuindex + 1;
            oushuHuiwen(flag, nexoushuindex);
        }


    }

    //偶数判断
    //oushouIndex 用来定位
    private void oushu(int flag, int compare, int minFlag, int oushIndex) {

        if (flag - compare >= 0 && oushIndex * 2 > huiwenLenth
                && minFlag + compare < length
                && array[flag - compare] == array[minFlag + compare]
        ) {
            //如果位移到相邻值的时候进行返回
            if (flag - compare == minFlag + compare - 1) {
                oushuB = true;
                return;
            }
            oushu(flag, compare + 1, minFlag, oushIndex);
        } else {
            oushuB = false;
            return;
        }
    }

    /**
     * 将地址段转为字符串
     *
     * @param first
     * @param end
     * @return
     */
    private String getString(int first, int end) {
        String huiwen = "";
        for (int i = 0; i < array.length; i++) {
            if (i >= first && i <= end) {
                huiwen = huiwen + array[i];
            }
        }
        return huiwen;
    }



    public static void main(String[] args) {

        System.out.println(new Solution().longestPalindrome("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"));
    }
}
