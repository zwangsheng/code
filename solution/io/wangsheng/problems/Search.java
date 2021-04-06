package io.wangsheng.problems;

/**
 * topic: [33].搜索旋转排序数组
 * description: 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。
 * difficulty: 中等
 * tags: 数组，二分，旋转数组
 * author: wangSheng
 */
public class Search {
    // 总体思路采用二分查找
    public int search1(int[] nums, int target) {
        int len = nums.length;
        // 特殊值判断
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        // 二分指针
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 先判断左右哪块是按顺序来的，利用按顺序来的那块进行二分查找
            if (nums[0] <= nums[mid]) {
                // 判断所选数字在不在这块里面
                // 在的话就缩小范围
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    // 不在就选另一块
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
