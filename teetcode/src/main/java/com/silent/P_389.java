package com.silent;

import java.util.HashMap;
import java.util.Map;

/**
 * Author liutao
 * Date 2020/5/11 10:34 下午
 * Description:
 * Version: 1.0
 **/
public class P_389 {


    public char findTheDifference(String s, String t) {

        Map<Character, Integer> map = new HashMap();
        // 初始化map
        char[] sArray = s.toCharArray();
        //初始化数据
        for (int i = 0; i < sArray.length; i++) {
            Character data = sArray[i];
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else {
                map.put(data, 1);
            }
        }
        char[] tArray = t.toCharArray();

        //开始帅选数据
        for (int i = 0; i < tArray.length; i++) {
            Character data = tArray[i];
            if (map.containsKey(data)) {
                if (map.get(data) == 0) {
                    return data;
                } else {
                    map.put(data, map.get(data) - 1);
                }
            } else {
                return data;
            }
        }
        return '0';
    }



    public  char b(String s, String t){
        char[] sc=s.toCharArray();
        char[] cc=t.toCharArray();
        int[] num=new int[26];
        int[] num1=new int[26];
        for(int i=0;i<s.length();i++){
            num[sc[i]-'a']++;
        }
        for(int i=0;i<t.length();i++){
            num1[cc[i]-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(num1[cc[i]-'a']!=num[cc[i]-'a']){
                return cc[i];
            }
        }
        return cc[t.length()-1];

    }

    public static void main(String[] args) {
        String aaa="aaabbbccc";
        String bbb="aaadbbbccc";
        new P_389().cb(aaa,bbb);
    }

    public  char cb(String s, String t){

        char res=0;
        for(Character character:s.toCharArray()){
            res^=character;
            System.out.println(" S character is "+character + " res is "+res);
        }
        for(Character character:t.toCharArray()){
            res^=character;
            System.out.println(" T  character is "+character + " res is "+res);
        }
    return res;

    }
}
