import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * topic: [368].最大整除子集
 * description: 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集
 * difficulty: 中等
 * tags: 数组，动态规划
 * author: wangSheng
 */
public class LargestDivisibleSubset {
    // 主要思路还是排序之后当前的作为最大整数去判断，然后dp的时候注意挑最大的值
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.sort(nums);
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxValue = nums[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    // 在这里要选择最大的值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //  迭代
            if (dp[i] > maxSize) {
                maxValue = nums[i];
                maxSize = dp[i];
            }
        }

        // 从后往前把一个个数字挑出来
        for (int i = len - 1; i >= 0; i--) {
            if (maxSize == dp[i] && maxValue % nums[i] == 0) {
                ans.add(nums[i]);
                maxValue = nums[i];
                maxSize--;
            }
        }
        return ans;
    }
}
