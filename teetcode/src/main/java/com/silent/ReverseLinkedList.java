package com.silent;


import com.base.LinkNodeOperation;
import com.silent.leetcode02.Solution;

/**
 * @author liutao
 * Date 2021/2/25 7:36 上午
 * Description:
 * Version: 1.0
 **/
public class ReverseLinkedList {

    public static void main(String[] args) {
        Node head=new Node(1);
       Node node1=  head.next=new Node(2);
       Node node2=  node1.next=new Node(3);
        node2.next=new Node(4);

        printNode(head);
       Node re= reverseLinkedRecursion(head);
        printNode(re);
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


    private static Node reverseLinked(Node head) {
        if (head.next == null) {
            return head;
        }
        Node preNode = null;
        Node currentNode = head;
        Node temp;
        while (currentNode != null) {
            temp = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = temp;
        }

        return preNode;
    }

    /**
     * 递归进行翻转
     * @param head
     * @return
     */
    private static Node reverseLinkedRecursion(Node head){

        if(head.next==null ) {
            return head;
        }
        System.out.println("==head===");
        printNode(head);
        Node last=reverseLinkedRecursion(head.next);
        System.out.println("= last====");
        printNode(last);
        printNode(head.next);
        head.next.next=head;

        head.next=null;
        printNode(head);


        return last;
    }


    public static class Node {

        int value;

        Node next;

        Node(int value) {
            this.value = value;
        }
    }


}
