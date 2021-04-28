package io.wangsheng.problems;

import io.wangsheng.problems.need.ListNode;

/**
 * topic: [160].相交链表
 * description: 编写一个程序，找到两个单链表相交的起始节点。
 * difficulty: 简单
 * tags: 链表，图论
 * author: wangSheng
 */
public class GetIntersectionNode {
    // 如果有相交的点，那么相交之后的长度是一样长的
    // 最重要的还是先去掉前面长度差
    // 利用快满节点进行比较，最后如果撞在一起就是结果
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode head1 = headA;
        ListNode head2 = headB;
        // 都到结尾了也会结束条件
        while (head1 != head2) {
            // 换到开头去
            head1 = (head1 == null) ? headB : head1.next;
            head2 = (head2 == null) ? headA : head2.next;
        }
        return head1;
    }
}
