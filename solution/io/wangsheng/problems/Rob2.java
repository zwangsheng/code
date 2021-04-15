package io.wangsheng.problems;

/**
 * topic: [213].打家劫舍二
 * description: 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。数组是个环，第一家个和最后一家连在一起
 * difficulty: 中等
 * tags: 动态规划，数组
 * author: wangSheng
 */
public class Rob2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 重新划分进行比较
        return Math.max(helper(nums, 0, len - 2), helper(nums, 1, len - 1));
    }

    // 思路参照[198].打家劫舍
    public int helper(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int num = second;
            second = Math.max(first + nums[i], second);
            first = num;
        }
        return second;
    }
}
