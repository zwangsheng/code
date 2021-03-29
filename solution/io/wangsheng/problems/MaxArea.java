package io.wangsheng.problems;

/**
 * topic: [11].盛最多水的容器
 * description: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * difficulty: 中等
 * tags: 数组，双指针
 * author: wangSheng
 */
public class MaxArea {

    public int maxArea1(int[] height) {
        // 双指针
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        // 左右移动
        while (left < right) {
            int num;
            // 寻找最短板
            // 计算，移动
            if (height[left] < height[right]) {
                num = height[left] * (right - left);
                left++;
            } else {
                num = height[right] * (right - left);
                right--;
            }
            // 迭代
            max = Math.max(max, num);
        }
        return max;
    }
}
