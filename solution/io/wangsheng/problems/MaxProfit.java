package io.wangsheng.problems;

/**
 * topic: [121].买卖股票的最佳时机
 * description: 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * difficulty: 简单
 * tags: 数组，动态规划
 * author: wangSheng
 */
public class MaxProfit {
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int ans = 0;
        int min = Integer.MAX_VALUE;
        // 进行迭代记录
        for (int num : prices) {
            // 迭代更新最小值
            if (num < min) {
                min = num;
            } else {
                // 如果不是最小值就进行计算今天卖出去的利润
                int profit = num - min;
                if (profit > ans) {
                    ans = profit;
                }
            }
        }
        return ans;
    }
}
