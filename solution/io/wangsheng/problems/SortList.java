package io.wangsheng.problems;

import io.wangsheng.problems.need.ListNode;

/**
 * topic: [148].排序链表
 * description: 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * difficulty: 中等
 * tags: 链表，递归
 * author: wangSheng
 */
public class SortList {
    // 合并两个列表
    MergeTwoLists mergeTwoLists = new MergeTwoLists();

    // 采用归并排序
    public ListNode sortList(ListNode head) {
        return helper(head, null);
    }

    // 进行拆分
    public ListNode helper(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        // 先拆
        ListNode left = helper(head, slow);
        ListNode right = helper(slow, tail);
        // 拆到最后进行合并
        return mergeTwoLists.mergeTwoLists(left, right);
    }
}
