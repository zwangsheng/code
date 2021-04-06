package io.wangsheng.problems;

/**
 * topic: [80].删除有序数组中的重复项二
 * description: 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * difficulty: 中等
 * tags: 数组，双指针
 * author: wangSheng
 */
public class RemoveDuplicates2 {
    // 基本思路与[26].删除有序数组中的重复项类似
    // 多了一个判断
    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 指向前一种数字
        boolean flag = true;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            // 如果这个数字虽然重复，但是还能接受
            if (nums[i] == nums[index] && flag) {
                nums[++index] = nums[i];
                // 条件设置
                flag = false;
            }
            // 判断移动
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
                // 条件复原
                flag = true;
            }
        }
        return index + 1;
    }
}
