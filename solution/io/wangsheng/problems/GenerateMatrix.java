package io.wangsheng.problems;

/**
 * topic: [59].螺旋矩阵二
 * description: 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * difficulty: 中等
 * tags: 数组，模拟
 * author: wangSheng
 */
public class GenerateMatrix {
    // 基本思路还是参考[54].螺旋举证
    public int[][] generateMatrix1(int n) {
        int[][] ans = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bot = n - 1;
        int num = 1;
        while (left <= right && top <= bot) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = num++;
            }
            for (int i = top + 1; i <= bot; i++) {
                ans[i][right] = num++;
            }
            // 因为生成的数组肯定满足n^2所以没必要进行判断
            for (int i = right - 1; i > left; i--) {
                ans[bot][i] = num++;
            }
            for (int i = bot; i > top; i--) {
                ans[i][left] = num++;
            }
            left++;
            top++;
            right--;
            bot--;
        }
        return ans;
    }
}
