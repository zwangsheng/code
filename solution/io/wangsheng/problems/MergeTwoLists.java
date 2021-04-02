package io.wangsheng.problems;

import io.wangsheng.problems.need.ListNode;

/**
 * topic: [21].合并两个有序链表
 * description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * difficulty: 简单
 * tags: 链表，递归
 * author: wangSheng
 */
public class MergeTwoLists {
    // 迭代判断
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // 假头
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        // 两个都不为空的话，需要判断大小
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 一个为空直接连上另一个
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return head.next;
    }

    // 递归问题
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 注意边界
        // 拆分成小问题，进行连接
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
