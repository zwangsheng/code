package io.wangsheng.problems;

import java.util.LinkedList;

public class MinStack {
    // 存放所有数字
    LinkedList<Integer> nums = new LinkedList<>();
    // 存放最小值
    LinkedList<Integer> mins = new LinkedList<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        nums = new LinkedList<>();
        mins = new LinkedList<>();
    }

    public void push(int val) {
        nums.push(val);
        // 维持一个最小栈
        if (mins.isEmpty() || mins.peek() >= val) {
            mins.push(val);
        }
    }

    public void pop() {
        // 弹出的时候判断是不是最小栈的栈顶
        // 如果是的时候就说明这个最小的要被移除了
        // 那么下个最小的刚好就是最小堆的下个元素
        // 这里一定要用equals
        if (mins.peek().equals(nums.pop())) {
            mins.pop();
        }
    }

    public int top() {
        return nums.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}
