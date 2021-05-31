package io.wangsheng.problems;

/**
 * topic: [215].数组中的第k个最大元素
 * description: 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * difficulty: 中等
 * tags: 快速排序，分治
 * author: wangSheng
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    // 利用快排进行数组排序
    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            // 基数
            int num = nums[i];
            while (i < j) {
                // 寻找比基数小的数
                while (i < j && nums[j] >= num) j--;
                // 判断是否到了数组的边界
                if (i < j) nums[i++] = nums[j];
                // 寻找比基数大的数
                while (i < j && nums[i] <= num) i++;
                // 判断是否到了数组的边界
                if (i < j) nums[j--] = nums[i];
            }
            // 基数填到中间
            nums[i] = num;
            // 进入分治
            // 中间的基数不需要进行下一轮分治
            quickSort(nums, left, i - 1);
            quickSort(nums, i+1, right);
        }
    }
}
