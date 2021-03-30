package io.wangsheng.problems;

/**
 * topic: [74].搜索二维矩阵
 * description: 编写一个高效的算法来判断 <code>m x n</code> 矩阵中，是否存在一个目标值。
 * difficulty: 中等
 * tags: 二分，数组
 * author: wangSheng
 */
public class SearchMatrix {

    // 利用这个数组的特殊性
    // 对左下角的数字进行二分查找
    public boolean searchMatrix1(int[][] matrix, int target) {
        // 空值判断
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // index
        int i = matrix.length - 1;
        int j = 0;
        // 定位到哪一行
        for (; i >= 0; i--) {
            if (matrix[i][j] <= target) {
                break;
            }
        }
        // 判断有无越界
        if (i == -1) {
            return false;
        }
        // 在定位到的这行里面进行计算
        for (; j < matrix[0].length; j++) {
            if (matrix[i][j] == target) {
                return true;
            }
            // 左边的小于target，右边的大于target说明没有必要找了
            if (matrix[i][j] > target) {
                return false;
            }
        }
        // 这一行找不到
        return false;
    }

    // 把这个二维数组压平，然后进行二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length;
        int j = matrix[0].length;
        int left = 0;
        int right = i * j - 1;
        // 经典二分
        while (left <= right) {
            int mid = (left + right) / 2;
            // 在这里要注意换行的问题
            int num = matrix[mid / j][mid % j];
            if (num < target) {
                left = mid + 1;
            } else if (num > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
