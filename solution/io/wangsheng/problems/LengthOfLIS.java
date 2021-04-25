package io.wangsheng.problems;

import java.util.Arrays;

/**
 * topic: [300].最长递增子序列
 * description: 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * difficulty: 中等
 * tags: 数组，动态规划
 * author: wangSheng
 */
public class LengthOfLIS {
    // 进行dp
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxlen = 1;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        // 认定当前的为最大值，那么就是前面比他小的加1，注意选择最大的可能性
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 迭代
            if (dp[i] > maxlen) {
                maxlen = dp[i];
            }
        }
        return maxlen;
    }
}
