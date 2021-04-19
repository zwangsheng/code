package io.wangsheng.problems;

/**
 * topic: [27].移除元素
 * description: 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * difficulty: 简单
 * tags: 数组，双指针
 * author: wangSheng
 */
public class RemoveElement {
    // 思路双指针，一个指向遍历的一个指向结尾
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        // 进行双指针遍历
        while (left <= right) {
            // 遇到符合条件的就进行左右指针的交换
            // 但是在交换以后左指针不能移动
            // 可能交换过来的也是符合条件的数字
            // 所以只移动右指针就好了
            if (nums[left] == val) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
