package io.wangsheng.problems;

import io.wangsheng.problems.need.ListNode;

/**
 * topic: [141].环型链表
 * description: 给定一个链表，判断链表中是否有环。
 * difficulty: 简单
 * tags: 链表，环，双指针
 * author: wangSheng
 */
public class HasCycle {
    // 快慢双指针的思想
    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        // 快指针始终比慢指针移动的快一倍
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null &&fast.next != null) {
            // 撞一起了就说明有环
            if (slow.equals(fast)) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    // 标记的思想，遍历一遍，遍历到了一样的地方就说明到了连接节点
    public boolean hasCycle2(ListNode head) {
        while (head != null) {
            if (head.val == 0xcafebabe) {
                return true;
            }
            head.val = 0xcafebabe;
            head = head.next;
        }
        return false;
    }
}
