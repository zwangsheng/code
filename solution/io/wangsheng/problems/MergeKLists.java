package io.wangsheng.problems;

import io.wangsheng.problems.need.ComparableListNode;
import io.wangsheng.problems.need.ListNode;

import java.util.PriorityQueue;

/**
 * topic: [23].合并k个升序链表
 * description: 给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * difficulty: 困难
 * tags: 链表，优先队列，二分
 * author: wangSheng
 */
public class MergeKLists {
    // [21].合并两个有序链表
    MergeTwoLists mergeTwoLists = new MergeTwoLists();

    // 一个一个合并
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode list : lists) {
            ans = mergeTwoLists.mergeTwoLists(ans, list);
        }
        return ans;
    }

    // 二分进行合并
    public ListNode mergeKLists2(ListNode[] lists) {
        return mergeHelper(lists, 0, lists.length - 1);
    }

    // 判断边界条件进行二分递归合并
    public ListNode mergeHelper(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        return mergeTwoLists.mergeTwoLists(mergeHelper(lists, left, mid), mergeHelper(lists, mid + 1, right));
    }

    // 通过往优先队列里面塞节点进行自动排序获取结果
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ComparableListNode> queue = new PriorityQueue<ComparableListNode>();
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(new ComparableListNode(list.val, list));
            }
        }
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            ComparableListNode node = queue.poll();
            tail.next = node.curr;
            tail = tail.next;
            // 注意边界条件
            if (node.curr.next != null) {
                queue.offer(new ComparableListNode(node.curr.next.val, node.curr.next));
            }
        }
        return head.next;
    }
}
