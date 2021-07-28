package com.silent.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckDoubbeTest {
    public boolean containsDuplicate(int[] nums) {
        int length=nums.length;
        Map<Integer,Integer> hashmap=new HashMap<>(length);
        for (int i=0;i<length;i++){
            hashmap.put(nums[i],i);
        }
        return length!=hashmap.size();
    }

    public static void main(String[] args) {

    }
}
