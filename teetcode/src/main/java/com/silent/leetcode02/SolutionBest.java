package com.silent.leetcode02;

/**
 * Author liutao
 * Date 2020/1/15 10:19 上午
 * Description:
 * Version: 1.0
 **/
public class SolutionBest {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
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
