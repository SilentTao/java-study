package com.base;

import com.base.list.LinkNode;

/**
 * @author liutao
 * Date 2021/2/25 7:18 上午
 * Description:
 * Version: 1.0
 **/
public class LinkNodeOperation {

    private LinkNode head;
    private LinkNode end;
    private Integer size;

    public static void main(StringTest[] args) {

        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        printNode(head);


    }

    public static void printNode(Node node) {
        System.out.println("开始打印链表");
        Node printNode = node;
        while (printNode != null) {
            System.out.print(printNode.value + ",");
            printNode = printNode.next;
        }
        System.out.println("结束打印链表");
    }



    public static class Node {

        int value;

        Node next;

        Node(int value) {
            this.value = value;
        }
    }


}
