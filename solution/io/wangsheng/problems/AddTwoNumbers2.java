package io.wangsheng.problems;

import io.wangsheng.problems.need.ListNode;

/**
 * topic: [2].两数相加2
 * description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * difficulty: 中等
 * tags: 链表，逻辑
 * author: wangSheng
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode cur = ans;
        int mark = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + mark;
            mark = sum / 10;
            cur.next = new ListNode(mark % 10);

            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (mark != 0) {
            cur.next = new ListNode(1);
        }
        return ans.next;
    }
}
