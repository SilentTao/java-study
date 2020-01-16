package com.silent.leetcode02;

/**
 * Author liutao
 * Date 2020/1/15 10:25 上午
 * Description: 只需遍历最少的链的长度
 * Version: 1.0
 **/
public class SolutionTow {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int head = l1.val + l2.val;
        int code = head / 10;  // 初始化进位符
        //都移到链表的第二位, 在循环中判断是否存在
        l1 = l1.next;
        l2 = l2.next;
        if (l1 == null && l2 == null) {
            if (head == 0 || code == 0) {
                ListNode ListNode = new ListNode(head % 10);
                return ListNode;
            }
            ListNode ListNode = new ListNode(head % 10);
            ListNode.next = new ListNode(code);
            return ListNode;
        }
        ListNode nodeHead = new ListNode(head % 10);
        ListNode ListNodeSum = nodeHead;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            //在此轮的求和中两个链表都存在加数
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + code;
                code = sum / 10;
                ListNodeSum.next = new ListNode(sum % 10);
                ListNodeSum = ListNodeSum.next;
                //链表移位
                l1 = l1.next;
                l2 = l2.next;
            }
            if (l1 == null && l2 != null) {
                sum = l2.val + code;
                code = sum / 10;
                ListNodeSum.next = new ListNode(sum % 10);
                ListNodeSum = ListNodeSum.next;
                if (flag == 1 && code == 0) {

                    //拼接剩余链表
                    ListNodeSum.next = l2.next;
                    ListNodeSum = ListNodeSum.next;
                    break;
                }
                l2 = l2.next;
                flag = 1;
            }
            if (l1 != null && l2 == null) {
                sum = l1.val + code;
                code = sum / 10;
                ListNodeSum.next = new ListNode(sum % 10);
                ListNodeSum = ListNodeSum.next;

                if (flag == 1 && code == 0) {

                    //拼接剩余链表
                    ListNodeSum.next = l1.next;
                    ListNodeSum = ListNodeSum.next;
                    break;
                }
                l1 = l1.next;
                flag = 1;
            }
        }
        if (code > 0) {
            ListNodeSum.next = new ListNode(code);
            ListNodeSum = ListNodeSum.next;
        }
        return nodeHead;
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
