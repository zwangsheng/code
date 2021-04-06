package io.wangsheng.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * topic: [54].螺旋矩阵
 * description: 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * difficulty: 中等
 * tags: 数组，模拟
 * author: wangSheng
 */
public class SpiralOrder {
    // 主体还是采用模拟的思想
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        // 特殊值判断
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        // 设置的边界
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0;
        int bot = rows - 1;
        int left = 0;
        int right = cols - 1;
        while(left <= right && top <= bot) {
            // 进行一圈循环
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            // 注意一些参数的设置
            // 这些设置可以帮助去掉重复的数字
            // 最好写的时候画个图
            // 像这里的top+1就是为了跳过右上角的重复
            for (int i = top + 1; i <= bot; i++) {
                ans.add(matrix[i][right]);
            }
            // 在这里进行判断是为了防止只有一行的矩阵
            if (left < right && top < bot) {
                for (int i = right - 1; i > left; i--) {
                    ans.add(matrix[bot][i]);
                }
                for (int i = bot; i > top; i--) {
                    ans.add(matrix[i][left]);
                }
            }
            // 在这里统一移动边界
            left++;
            top++;
            right--;
            bot--;
        }
        return ans;
    }
}
