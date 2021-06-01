package io.wangsheng.problems;

import java.util.HashSet;

/**
 * topic: [217].存在重复元素
 * description:给定一个整数数组，判断是否存在重复元素。如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * difficulty: 简单
 * tags: hash，数组
 * author: wangSheng
 */
public class ContainsDuplicate {

    // 利用hashSet判断能不能存进去
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
