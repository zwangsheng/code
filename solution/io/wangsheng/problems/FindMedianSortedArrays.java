package io.wangsheng.problems;

/**
 * topic: [4].寻找两个正序数组的中位数
 * description: 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * difficulty: 困难
 * tags: 数组，二分查找，中位数，双指针
 * author: wangSheng
 */
public class FindMedianSortedArrays {

    // 移动指针一定的位数然后计算中位数
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int left = -1;
        int right = -1;
        int index1 = 0;
        int index2 = 0;
        // 无论奇偶，都需要遍历一半
        for(int i = 0; i <= len/2; i++)  {
            // 记录前一个，偶数的情况有用
            left = right;
            // 判断移动哪个指针，还得注意边界条件
            right = (index1 < len1 && (index2 >= len2 || nums1[index1] < nums2[index2])) ? nums1[index1++] : nums2[index2++];
        }
        // 判断数组的长度，计算中位数
        return ((len & 1) == 0) ? (left + right) / 2.0 : right;
    }

    // 利用递归去除前k/2小的数字
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        // 如果是奇数的话，left的数字等于right的数字
        // 要做判断的话也行
        return (helper(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left) + helper(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) * 0.5;
    }

    public int helper(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        // 交换，保证len1最小
        if (len1 > len2) {
            return helper(nums2, start2, end2, nums1, start1, end1, k);
        }

        // 递归结束条件之一
        // 中位数只存在一个数组上
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }

        // 递归结束条件之一
        // 两个数组头部最小的一个为中位数
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        // 为了防止长度小于len/2，剔除的时候剔除实际的长度
        int index1 = start1 + Math.min(len1, k / 2) - 1;
        int index2 = start2 + Math.min(len2, k / 2) - 1;

        // 剔除k/2的数字后，进入递归，并且明确下次要剔除多少的最小数
        if (nums1[index1] < nums2[index2]) {
            return helper(nums1, index1 + 1, end1, nums2, start2, end2, k - Math.min(len1, k / 2));
        } else {
            return helper(nums1, start1, end1, nums2, index2 + 1, end2, k - Math.min(len2, k / 2));
        }
    }

    // 采用了数学论证后的二分结论
    // 如果i 和 j的分割线找到了中位数
    // 那么
    // 1. 如果长度是偶数，i，j左边的数组长度相加相等
    // 即 i + j = m - i + n - j; => j = (m+n) / 2 - i
    // 如果长度是技术，i，j左边的数组长度比右边多1
    // 即 i + j = m - i + n - j + 1; => j = (m+n+1) /2 -i
    // 对于/2来说，上面+1无影响，所以无论奇偶可以统一为 j = (m + n + 1) /2 - i;
    // 2. 如果长度是偶数，中位数是左边的最大+右边的最小*0.5
    // 如果长度是奇数，中位数是左边多出来的那个，就是0最大的那个
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 > len2) {
            return findMedianSortedArrays3(nums2, nums1);
        }

        int indexMin = 0;
        int indexMax = len1;
        // 双指针进行移动
        while (indexMin <= indexMax) {
            // 二分移动
            int index1 = (indexMin + indexMax) / 2;
            int index2 = (len1 + len2 + 1) / 2 - index1;
            if (index2 != 0 && index1 != len1 && nums2[index2 - 1] > nums1[index1]) {
                indexMin = index1 + 1;
            } else if (index1 != 0 && index2 != len2 && nums2[index2] < nums1[index1 - 1]) {
                indexMax = index1 - 1;
            } else {
                // 判断边缘条件和奇偶条件进行计算
                int left = (index1 == 0 || index2 == 0) ? (index1 == 0 ? nums2[index2 - 1] : nums1[index1 - 1]) : (Math.max(nums1[index1 - 1], nums2[index2 - 1]));
                if (((len1+len2) & 1) == 1) {
                    return left;
                }

                int right = (index1 == len1 || index2 == len2) ? (index1 == len1 ? nums2[index2] : nums1[index1]) : (Math.min(nums1[index1], nums2[index2]));
                return (left + right) * 0.5;
            }
        }
        return 0D;
    }
}
