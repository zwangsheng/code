package io.wangsheng.problems;

/**
 * topic: [70].爬楼梯
 * description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * difficulty: 简单
 * tags: 斐波那契数列，动态规划
 * author: wangSheng
 */
public class ClimbStairs {
    // 斐波那契数列
    // 动态规划
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
