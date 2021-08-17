package com.slient.cache;

import java.util.*;

/**
 * @author liutao
 * Date 2021/8/9 4:57 下午
 * Description:
 * Version: 1.0
 **/
public class DoubleNode {


    public   DoubleNode pre;
    public   DoubleNode next;
    public   int value;

    public DoubleNode getPre() {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        Set<Integer> integers=new HashSet<>();
        integers.toArray();
        Object[] datas=    integers.toArray();
        List<Integer> list=new ArrayList<>();
        list.toArray();
        return pre;
    }

    public void setPre(DoubleNode pre) {
        this.pre = pre;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
