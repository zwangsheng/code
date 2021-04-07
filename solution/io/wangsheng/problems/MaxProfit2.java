package io.wangsheng.problems;

public class MaxProfit2 {

    // 动态规划
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        // 一开始的条件
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            // 主要的dp公式
            // 如果是手头没股的情况，那么要么是上一轮就没买，要么是上一轮买了，选择最大收益的
            // 如果是手头有股的情况，那么要么是上一轮买了没动，要么是上一轮没买，买了这一轮的
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len-1][0];
    }

    // 优化空间消耗
    // 总体思路与上类似
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < len; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dp0 - prices[i]);
        }
        return dp0;
    }

    // 贪心的思想
    // 1 - 3 - 7
    // 从 1 到 7 再卖和 1 卖 7 买 3 卖 7 是一样的
    public int maxProfit3(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(0, prices[i] - prices[i-1]);
        }
        return ans;
    }
}
