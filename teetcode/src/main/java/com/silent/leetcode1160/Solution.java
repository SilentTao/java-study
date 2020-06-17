package com.silent.leetcode1160;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * Version: 1.0
 **/
public class Solution {
    /**
     * 示例 1：
     * <p>
     * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
     * 输出：6
     * 解释：
     * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
     * 示例 2：
     * <p>
     * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
     * 输出：10
     * 解释：
     * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= words.length <= 1000
     * 1 <= words[i].length, chars.length <= 100
     * 所有字符串中都仅包含小写英文字母
     *
     * @param args 第一考察对字符串的理解
     */
    public static void main(String[] args) {
        String chars = "wellonehoneyrd";
        String[] words = {"hello", "world", "leetcode"};
        Solution solution = new Solution();
        System.out.println(solution.countCharacters(words, chars));

    }

    public int countCharacters(String[] words, String chars) {

        int[] map = new int[26];
        for (char c : chars.toCharArray()) {
            map[c - 'a']++;

        }
        int count = 0;
        for (String word : words) {
            int[] mapWord = new int[26];
            //计算出每个字母的定位, 也可以用hashMap去做
            for (char c : word.toCharArray()) {
                mapWord[c - 'a']++;
            }
            boolean can = true;
            for (int i = 0; i < mapWord.length; i++) {
                //如果单次所需个数大于提供的个数
                if (map[i] < mapWord[i]) {
                    can = false;
                    break;
                }
            }
            if (can) {
                count = count + word.length();
                System.out.println("能够拼出单词:" + word);
            }
        }


        return count;

    }


}
