package io.wangsheng.problems;

/**
 * topic: [53].最大子序和
 * description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * difficulty: 简单
 * tags: 数组，动态规划
 * author: wangSheng
 */
public class MaxSubArray {
    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        // 利用动态规划
        for(int num : nums) {
            sum += num;
            // 注意点，需要先判断，在归零，免得出现负数的情况
            if (sum > max) {
                max = sum;
            }
            // 不满足条件，重新开始计算
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
