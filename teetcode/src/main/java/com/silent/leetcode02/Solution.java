package com.silent.leetcode02;

/**
 * Author liutao
 * Date 2020/1/14 10:05 下午
 * Description:
 * Version: 1.0
 **/
public class Solution {

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
                //链表移位
                l2 = l2.next;
            }
            if (l1 != null && l2 == null) {
                sum = l1.val + code;
                code = sum / 10;
                ListNodeSum.next = new ListNode(sum % 10);
                ListNodeSum = ListNodeSum.next;
                //链表移位
                l1 = l1.next;
            }
        }
        return nodeHead;
    }

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param args
     */

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2).next = new ListNode(2).next = new ListNode(2);
        ListNode l2 = new ListNode(2).next = new ListNode(2).next = new ListNode(2);
        ListNode sum = addTwoNumbers(l1, l2);
        while (sum != null) {
            System.out.println(sum.val);
            sum = sum.next;
        }

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
