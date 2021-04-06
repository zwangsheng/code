package io.wangsheng.problems;

import io.wangsheng.problems.need.ListNode;

/**
 * topic: [61].旋转链表
 * description: 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * difficulty: 中等
 * tags: 链表，双指针，链表环
 * author: wangSheng
 */
public class RotateRight {
    // 快慢双指针
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || k == 0) return head;
        // 计算链的长度，旋转多少圈无关，主要是偏移量
        int count = 1;
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            count++;
        }
        // 计算偏移量
        k %= count;
        if (k == 0) return head;
        // 利用快慢指针进行移动
        // 快指针到达尾部的时候慢节点指向新头
        ListNode slow = head, fast = head;
        // 快指针先跑
        while (k-- > 0) fast = fast.next;
        // 一起跑
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 保存新头结点
        ListNode nHead = slow.next;
        // 断开连接
        slow.next = null;
        // 进行连接
        fast.next = head;
        return nHead;
    }

    // 封闭成环
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || k == 0) return head;
        // 同样进行计算链长，同时去掉无效的圈数
        int count = 1;
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            count++;
        }
        k %= count;
        if (k == 0) return head;
        // 连接成环
        tmp.next = head;
        // 计算出来多少步到新头
        k = count - k - 1;
        while (k-- > 0) head = head.next;
        // 记录新头
        ListNode nHead = head.next;
        // 断开连接
        head.next = null;
        return nHead;
    }
}
