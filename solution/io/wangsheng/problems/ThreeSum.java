package io.wangsheng.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * topic: [15].三数之和
 * description: 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * difficulty: 中等
 * tags: 数组，双指针
 * author: wangSheng
 */
public class ThreeSum {

    // 思路，固定一个值，然后利用双指针进行取值
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 大于0，那么右边的都没有意义
            if (nums[i] > 0) {
                break;
            }
            // 为了跳过重复的数字
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 双指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                // 进行结果判断
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 同一个值不一定只有一对，跳过重复的继续双指针
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }
}
