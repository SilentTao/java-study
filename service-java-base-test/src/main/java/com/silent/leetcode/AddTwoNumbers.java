package com.silent.leetcode;

/**
 * \* User: silent
 * \* Date: 15/03/19 Time: 14:52
 * \* Description:
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * \
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(5);
        l1.next = a;
        l2.next = b;
        a.next = new ListNode(4);
        b.next = new ListNode(9);
        display(l1);
        display(l2);
        ListNode aa = addTwoNumbers(l1, l2);
        display(aa);

    }

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
        display(curr);
        return dummyHead.next;
    }

    public static void display(ListNode pHead) {
        while (pHead != null) {
            System.out.print(pHead.val + "\t");
            pHead = pHead.next;
        }
        System.out.println();
    }

}
