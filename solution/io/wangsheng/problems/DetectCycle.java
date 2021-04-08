package io.wangsheng.problems;

import io.wangsheng.problems.need.ListNode;

/**
 * topic: [142].环形链表二
 * description: 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * difficulty: 中等
 * tags: 链表，环，双指针
 * author: wangSheng
 */
public class DetectCycle {
    // 利用快慢双指针的思想
    // 设连接点前长度为a
    // 经过连接点之b后相遇
    // 还剩c走完环的一圈
    // 那么 fast 走过的路径就是 a + (n + 1) * b + n * c
    // 那么 slow 走过的路径就是 a + b
    // 又因为 fast 走过两倍的slow
    // 所以 a + (n + 1) * b + n * c = 2 * (a + b)
    // a = c + (n - 1) * c
    // 即 为未走完的路径加上n-1圈的环
    // 那么只要fast从头开始走，slow 继续走，必定在连接点相遇
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 进行循环，直到到了结尾或者，相遇
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (!slow.equals(fast));
        // 从头开始走
        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
