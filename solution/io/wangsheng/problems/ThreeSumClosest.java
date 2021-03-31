package io.wangsheng.problems;

import java.util.Arrays;

/**
 * topic: [16].最接近的三数之和
 * description: 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * difficulty: 中等
 * tags: 数组，双指针
 * author: wangSheng
 */
public class ThreeSumClosest {

    // 解题思路和15.三数之和类似
    // 利用双指针进行枚举
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int best = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // 判断绝对值谁接近
                if (Math.abs( target - sum) < Math.abs(target - best)) {
                    best = sum;
                }
                if (sum == target) {
                    return best;
                } else if (sum > target) {
                    while(left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    right--;
                } else {
                    while(left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    left++;
                }
            }
        }
        return best;
    }
}
