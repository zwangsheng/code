package io.wangsheng.problems;

/**
 * topic: [26].删除有序数组中的重复项
 * description: 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * difficulty: 简单
 * tags: 数组，双指针
 * author: wangSheng
 */
public class RemoveDuplicates {
    // 利用快慢指针进行对比和移动
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 指向前一种数字
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            // 判断移动
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
