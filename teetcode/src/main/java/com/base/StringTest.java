package com.base;

import java.util.Calendar;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author liutao
 * Date 2021/7/1 7:41 上午
 * Description:
 * Version: 1.0
 **/
public class StringTest {

    /**
     * ('，')'，'{'，'}'，'['，']'
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(check("{{{}}}"));
    }

    public static boolean check(String s){
        Stack<Character> stack=new Stack();
        HashMap<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put('[',']');
        char[] aaa=   s.toCharArray();
        for(int i=0;i<aaa.length;i++){
            //取出当前值
            Character character =new Character(aaa[i]);
            //如果map里边能够取到
            if(map.containsKey(character)){
                if(stack.isEmpty()) {
                    return false;
                }
                Character character1= stack.pop();
                if(!character1.equals(map.get(character))){
                    return false;
                }
            }else {
                stack.push(character);
            }
        }
        return stack.isEmpty();
    }




}
