package io.wangsheng.problems;

import io.wangsheng.problems.need.ListNode;

/**
 * topic: [82].删除排序链表中的重复元素 二
 * description: 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。返回同样按升序排列的结果链表。
 * difficulty: 中等
 * tags: 链表，遍历
 * author: wangSheng
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        // 空值判断
        if (head == null) {
            return null;
        }

        // 因为一开始的head也可能存在重复情况，所以整个假的head
        ListNode fakeHead = new ListNode(-1, head);

        // 指向前一个节点
        ListNode curr = fakeHead;
        // 当前的判断节点是curr.next
        while(curr.next != null && curr.next.next != null) {
            // 判断当前元素和当前元素的后一个是否一致
            if (curr.next.val == curr.next.next.val) {
                // 记录重复元素
                int num = curr.next.val;
                // 因为使用了while，所以还要在判断一下接下来是不是空
                // 吃掉所有的重复元素
                while (curr.next != null && curr.next.val == num) {
                    // 一直后移直到不一样
                    curr.next = curr.next.next;
                }
            } else {
                // 安全移动
                curr = curr.next;
            }
        }
        return fakeHead.next;
    }
}
