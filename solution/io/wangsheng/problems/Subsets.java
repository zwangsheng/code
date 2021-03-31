package io.wangsheng.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * topic: [78].子集
 * description: 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * difficulty: 中等
 * tags: 数组，二进制，递归，回溯
 * author: wangSheng
 */
public class Subsets {
    // 存放答案
    List<List<Integer>> ans = new ArrayList<>();
    // 存放可能性
    List<Integer> temp = new ArrayList<>();

    // 总体思路就是可以将集合用0/1串进行表示，发现规律最大的不超出2^n即1 << n
    public List<List<Integer>> subsets1(int[] nums) {
        int n = nums.length;
        // 明确个数
        for (int mask = 0; mask < (1 << n); mask++) {
            temp.clear();
            // 循环判断哪几个数字在这次里面
            for (int i = 0; i < n; i++) {
                // 判断当前位置有无为1的地方
                if ((mask & (1 << i)) != 0) {
                    temp.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }

    // 利用经典的回溯递归的方法
    public List<List<Integer>> subsets2(int[] nums) {
        dfsHelper(0, nums);
        return ans;
    }

    // 先装满，一个一个剔除
    public void dfsHelper(int cur, int[] nums) {
        // 递归结束条件
        if (cur == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        // 添加当前
        temp.add(nums[cur]);
        dfsHelper(cur + 1, nums);
        // 去除当前
        temp.remove(temp.size() - 1);
        dfsHelper(cur + 1, nums);
    }
}
