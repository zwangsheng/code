package io.wangsheng.problems;

/**
 * topic: [153].寻找旋转排序数组中的最小值
 * description: 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * difficulty: 中等
 * tags: 数组，二分，旋转数组
 * author: wangSheng
 */
public class FindMin {
    // 总体思路是二分查找
    // 如果这个点事最小的点
    // 那么这个点左边的所有值都大于他
    // 右边的所有值也大于他
    public int findMin1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // 如果左边按顺序，那么左半边不要
            // 如果右边按顺序，那么右半边不要
            // 这里存在一个优先级的问题
            // 如果数组本身就是有序的了
            // 那么应该先不要右边
            if (nums[right] > nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
