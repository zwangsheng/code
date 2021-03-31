package io.wangsheng.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * topic: [90].子集二
 * description: 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * difficulty: 中等
 * tags: 数组，二进制，递归，回溯
 * author: wangSheng
 */
public class SubsetsWithDup {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    // 在原来的基础上进行判断，重复的情况
    // 对于当前判断的数字，如果这个数字之前的相同的数字没有被选上，那么当前的结果已经在大集合里了
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            temp.clear();
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                // 当前数字符合条件
                if ((mask & 1 << i) != 0) {
                    // 判断重复性的时候，如果这个数字前面的数字没被选上，并且前后数字相同，那么跳过这个情况
                    if (i != 0 && ((mask >> (i - 1)) & 1) == 0 && nums[i] == nums[i - 1]) {
                        flag = false;
                        break;
                    }
                    temp.add(nums[i]);
                }
            }
            if (flag) {
                ans.add(new ArrayList<>(temp));
            }
        }
        return ans;
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        dfsHelper(false, 0, nums);
        return ans;
    }

    // 多了一个前一个数字是否被选择的参数
    public void dfsHelper(boolean preChosen, int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        // 先不选
        dfsHelper(false, cur + 1, nums);
        // 判断这次有没有必要进行选择
        if (!preChosen && cur != 0 && nums[cur] == nums[cur - 1]) {
            return;
        }
        temp.add(nums[cur]);
        dfsHelper(true, cur + 1, nums);
        temp.remove(temp.size() - 1);
    }
}
