package io.wangsheng.problems.need;


public class ComparableListNode implements Comparable<ComparableListNode> {
    public Integer val;
    public ListNode curr;

    public ComparableListNode(Integer val, ListNode curr) {
        this.val = val;
        this.curr = curr;
    }

    public int compareTo(ComparableListNode node2) {
        return this.val - node2.val;
    }
}