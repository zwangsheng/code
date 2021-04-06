package io.wangsheng.problems;

/**
 * topic: [88].合并两个有序数组
 * description: 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * difficulty: 简单
 * tags: 数组，排序
 * author: wangSheng
 */
public class Merge {
    // 从后往前进行放置
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur1 = m - 1;
        int cur2 = n - 1;
        int index = m + n -1;
        while(index >= 0) {
            // 注意边界的判断
            if (cur1 < 0 || cur2 < 0) {
                nums1[index--] = cur1< 0 ? nums2[cur2--] : nums1[cur1--];
            } else if (nums2[cur2] > nums1[cur1]) {
                nums1[index--] = nums2[cur2--];
            } else {
                nums1[index--] = nums1[cur1--];
            }
        }
    }
}
