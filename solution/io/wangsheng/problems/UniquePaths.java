package io.wangsheng.problems;

/**
 * topic: [62].不同路径
 * description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。机器人每次只能向下或者向右移动一步。
 * 机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。问总共有多少条不同的路径？
 * difficulty: 中等
 * tags: 数组，动态规划，回溯
 * author: wangSheng
 */
public class UniquePaths {
    int ans;
    int col;
    int row;
    // 利用模拟回溯，超时了
    // 主要思路就是dfs
    public int uniquePaths1(int m, int n) {
        this.ans = 0;
        this.col = m;
        this.row = n;
        helper(0, 0);
        return ans;
    }

    public void helper(int x, int y) {
        // 递归结束条件
        if (x == col - 1 && y == row - 1) {
            ans++;
        }
        // 剪枝
        if (x >= col || y >= row) {
            return ;
        }
        helper(x+1, y);
        helper(x, y+1);
    }

    // 采用动态规划的方法
    // dp[i][j] = dp[i-1][j] + dp[i][j-1]
    // 理解来说就是 这一格的可能性是前一步的两种可能性相加
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[n][m];
        // 初始化
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // 进行dp迭代
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        // 最后的节点是结果
        return dp[n-1][m-1];
    }

    // 在动态规划上进行优化
    // 递归公式为 dp[i] = dp[i] + dp[i-1]
    // 在原来的递归公式上进行了空间的优化
    // 因为只用到了上一格的本格以及前一格
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[m-1];
    }
}
