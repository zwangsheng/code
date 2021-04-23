package io.wangsheng.problems;

/**
 * topic: [198].打家劫舍
 * description: 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * difficulty: 中等
 * tags: 动态规划，数组
 * author: wangSheng
 */
public class Rob {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        // dp[i] =max( dp[i-2] + cur , dp[i-1])
        // 最后一个的值选择，要这个，不要这个
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }
}
