package com.silent;

import com.silent.common.ListNode;

/**
 * Author liutao
 * Date 2020/5/26 8:25 下午
 * Description:
 * Version: 1.0
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class leetcode_61 {


    public static void main(String[] args) {
        System.out.println(1% 2);
        ListNode head = new ListNode(0);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(3);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;


        System.out.println(rotateRight(head, 5).val);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        //尾部指针
        ListNode cur = head;
        int count = 1;
        //计算链表长度
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        //返回
        int index = 0;
        //计算实际出现的次数
        int xuangZhuanPoint = k % count;
        if (xuangZhuanPoint == 0) {
            return head;
        }

        cur.next = head;
        while (xuangZhuanPoint >= index) {
            cur = cur.next;
            //头节点向后移动
            head = head.next;
            index++;
        }
        //截去末尾节点
        cur.next = null;
        return head;

    }
}
