package io.wangsheng.problems;

import java.util.Stack;

/**
 * topic: [42].接雨水 || [面试题 17.21].直方图的水量
 * description: 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * difficulty: 困难
 * tags: 数组，双指针，栈
 * author: wangSheng
 */
public class Trap {

    // 双指针
    public int trap1(int[] height) {
        int ans = 0;
        int len = height.length;
        // 存放从左边迭代过来的最大边界
        int[] left = new int[len];
        // 存放从右边迭代过来的最大边界
        int[] right = new int[len];

        // 迭代获取，注意边界条件
        for (int i = 1; i < len - 1; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i > 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }

        // 抛弃边界开始进行
        for (int i = 1; i < len - 1; i++) {
            // 获得当前计算的挡板左右边界的最小值
            int min = Math.min(left[i], right[i]);
            // 判断能不能和当前的围起来
            // 围起来的话，只加上这一格的水量
            if (min > height[i]) {
                ans += min - height[i];
            }
        }
        return ans;
    }

    // 栈模拟
    public int trap2(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        // 每一个元素都进入判断
        for (int i = 0; i < height.length; i++) {
            // 栈是一个最小栈，栈顶元素最小
            // 碰到比栈顶大的元素就跳出
            // 因为入栈的时候除非栈为空，那么他就有了左边界，现在遇到比他大的数字，就是他的右边界
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                // 弹出当前的元素
                int curr = height[stack.pop()];
                // 判断有没有左边界，没有就漏水
                if (stack.isEmpty()) {
                    break;
                }
                // 因为不是一格一格的算，得判断跨越了多少
                int distance = i - stack.peek() - 1;
                // 拿出左右边界的最短板
                int min = Math.min(height[stack.peek()], height[i]);
                ans += distance * (min - curr);
            }
            // 每个元素都得进去
            stack.push(i);
        }
        return ans;
    }
}
