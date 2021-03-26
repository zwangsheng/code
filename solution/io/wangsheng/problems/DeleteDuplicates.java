package io.wangsheng.problems;

import io.wangsheng.problems.need.ListNode;

/**
 * topic: [83].删除排序链表中的重复元素
 * description: 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。返回同样按升序排列的结果链表。
 * difficulty: 简单
 * tags: 链表
 * author: wangSheng
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        // 空值判断
        if (head == null) {
            return null;
        }
        // 指正指向头结点
        ListNode cur = head;
        // 移动判断是否到结尾
        while (cur.next != null) {
            // 判断需要移动什么，移动当前的指针还是当前的指针的next指针
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
