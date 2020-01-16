package com.silent.leetcode03;

import java.util.HashMap;
import java.util.Map;

/**
 * Author liutao
 * Date 2020/1/15 7:41 下午
 * Description:
 * Version: 1.0
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://dev.lingkou.xyz/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution {
    /**
     * 思想滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        //设置默认的最长字符串大小
        int maxStringLength = 0;
        int length = s.length();
        //记录每次字符串长度临时值
        // 值
        Map<String, Integer> map = new HashMap<>(length);
        int headIndex = 0;
        int tailIndex = 0;
        //char[] chars=s.toCharArray();
        for (int i = 0; i < length; i++) {
            String nowString = s.substring(i, i + 1);
            // System.out.println("i is " + i + "  string is :" + nowString);
            Integer index = map.get(nowString);
            //说明此时还没有到达最大串
            if (index == null) {

                map.put(nowString, i);
                if (map.size() > maxStringLength) {
                    maxStringLength = map.size();
                    //   System.out.println("非重复 更新字符串最大长度:" + maxStringLength);
                }
                tailIndex = i;
                //开始出现重复字符串
                //  System.out.println("非重复 更新 head is " + headIndex + "tail is " + tailIndex);
            } else {
                // System.out.println("重复的index : " + index);
                // System.out.println("重复 head  更新 head is " + headIndex + "tail is " + tailIndex);
                // 判断和头节点重复
                if (index == headIndex) {
                    //移除旧的节点
                    map.remove(nowString);
                    headIndex = headIndex + 1; // 头向左偏移一位,继续往后判断
                    tailIndex = i; // 尾节点移动到当前的i位置
                    //加入新的节点
                    map.put(nowString, i);
                    //更新字符串长度
                    if (map.size() > maxStringLength) {
                        maxStringLength = map.size();
                    }
                    // System.out.println("重复 head 更新字符串最大长度:" + maxStringLength);
                    // System.out.println("重复 head  更新 head is " + headIndex + "tail is " + tailIndex);
                    continue;
                }
                //判断相临重复
                if (index == tailIndex) {
                    headIndex = i;  // 头节点移位到当前节点, 重新开始计算字符串长度
                    //移出所有旧的节点
                    map.clear();
                    //加入新的头节点
                    map.put(nowString, i);
                    //更新字符串长度
                    if (map.size() > maxStringLength) {
                        maxStringLength = map.size();
                    }
                    //  System.out.println("重复 tail  更新字符串最大长度:" + maxStringLength);
                    ///  System.out.println("重复 tail  更新 head is " + headIndex + "tail is " + tailIndex);
                    continue;
                }
                //判断中间重复
                if (headIndex < index && index < tailIndex) {

                    map = removeMap(map, index);

                    //移出左边的节点
                    //设置首尾几点的偏移量
                    headIndex = index;
                    tailIndex = i;
                    map.put(nowString, i);
                    //更新字符串长度
                    if (map.size() > maxStringLength) {
                        maxStringLength = map.size();
                    }
                    // System.out.println("重复 midle 更新字符串最大长度:" + maxStringLength);
                    //  System.out.println("重复 midle  更新 head is " + headIndex + "tail is " + tailIndex);
                    continue;

                }
            }

        }
        return maxStringLength;

    }

    private static Map<String, Integer> removeMap(Map<String, Integer> map, Integer index) {

        Map<String, Integer> hashmap = new HashMap<>();
        hashmap.putAll(map);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer indexa = entry.getValue();
            if (indexa <= index) {
                hashmap.remove(key);
            }
        }
        return hashmap;
    }


    public static void main(String[] args) {
        String s = "umsmvejcukuk";
        //  System.out.println(s.substring(0,3));
        System.out.println(lengthOfLongestSubstring(s));
    }

}
