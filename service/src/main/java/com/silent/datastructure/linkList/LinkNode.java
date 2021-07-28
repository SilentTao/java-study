package com.silent.datastructure.linkList;

public class LinkNode {


    private LinkNode pre;     // 上个节点的新纪录信息
    private int value;
    private LinkNode next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }

    public LinkNode getPre() {
        return pre;
    }

    public void setPre(LinkNode pre) {
        this.pre = pre;
    }
}
