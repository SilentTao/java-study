package com.silent;

/**
 * Author liutao
 * Date 2020/5/3 10:13 上午
 * Description:
 * Version: 1.0
 **/
public class leetcode_58 {

    public static void main(String[] args) {
//        char a = ' ';
//        System.out.println("aaa:" + (a + 0));
        String aaaaa = "Hello World1";
        System.out.println(new leetcode_58().lengthOfLastWord(aaaaa));

    }


    public int lengthOfLastWord(String s) {
        if (null == s || 0 >= s.length()) {
            return 0;
        }
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i --) {
            if (' ' != chars[i]) {
                sum ++;
            } else if (sum > 0) {
                return sum;
            }
        }
        return sum;
    }


}
