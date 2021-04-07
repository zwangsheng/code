package io.wangsheng.problems;

import java.util.Arrays;

/**
 * topic: [136].只出现一次的数字
 * description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * difficulty: 简单
 * tags: 数组，位运算
 * author: wangSheng
 */
public class SingleNumber {
    // 先排序，然后两格两格走
    public int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        // 两个两个迭代
        for (int i = 0; i < nums.length - 1; i += 2) {
            // 找到答案
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        // 到这里就说明最后一个是答案
        return nums[nums.length - 1];
    }

    // 位运算，相同的数字会自己和自己消掉
    // 最后剩下来的就是结果
    public int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
