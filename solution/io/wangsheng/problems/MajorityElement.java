package io.wangsheng.problems;

/**
 * topic: [169].多数元素
 * description: 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * difficulty: 简单
 * tags: 数组，摩尔投票
 * author: wangSheng
 */
public class MajorityElement {
    // 脑补hashTable存放
    // 遍历一遍就可以

    // 摩尔投票法
    // 一样的加一
    // 不一样的减一
    // 小于0之后进行切换
    public int majorityElement1(int[] nums) {
        int curNum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            // 投票逻辑
            if (nums[i] != curNum) {
                count--;
            } else {
                count++;
            }
            // 切换数字
            if (count < 0) {
                curNum = nums[i];
                count = 1;
            }
        }
        return curNum;
    }
}
