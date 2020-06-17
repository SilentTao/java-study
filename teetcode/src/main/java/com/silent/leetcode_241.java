package com.silent;

/**
 * Author liutao
 * Date 2020/6/11 10:36 下午
 * Description:
 * Version: 1.0
 **/
public class leetcode_241 {

    public static void main(String[] args) {
  new leetcode_241().isAnagram("aa","bb");
    }

    public boolean isAnagram(String s, String t) {
        int init = Integer.MAX_VALUE;
        System.out.println("data is "+init);
        char[] sArry = s.toCharArray();
        char[] tArry = t.toCharArray();
        for (char data : sArry) {
            init = init ^ data;
            System.out.println("data is "+data+"   init  is "+init);
        }
        for (char data : tArry) {
            init = init ^ data;
            System.out.println("data is "+data+"   init  is "+init);
        }

        return init == Integer.MAX_VALUE;

    }

}
