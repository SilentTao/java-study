package com.silent.jvm;


import java.util.HashMap;
import java.util.Map;

/**
 * Author liutao
 * Date 2020/5/28 9:57 上午
 * Description:
 * Version: 1.0
 *
 * @author liutao
 */
public class StringOperation {




    public char firstUniqChar(String s) {
        if(s==null||s.length()==0){
            return ' ';
        }

        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
            int data=chars[i]+'0';
            if(map.containsKey(data)){
                map.put(data,map.get(data)+1);
            }else{
                map.put(data,1);
            }
        }

        for(int j=0;j<chars.length;j++){
            int data= chars[j]+'0';
            int count=map.get(data);
            if(count==1){
                return chars[j];
            }
        }
        return ' ';
    }




}
