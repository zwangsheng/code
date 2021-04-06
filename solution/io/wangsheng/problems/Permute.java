package io.wangsheng.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * topic: [46].全排列
 * description: 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * difficulty: 中等
 * tags: 数组，递归，回溯
 * author: wangSheng
 */
public class Permute {
    List<List<Integer>> ans;
    int[] nums;
    boolean[] map;

    public List<List<Integer>> permute1(int[] nums) {
        this.ans = new LinkedList<>();
        this.nums = nums;
        this.map = new boolean[nums.length];
        backPermute(new LinkedList<Integer>());
        return ans;
    }

    private void backPermute(LinkedList<Integer> list) {
        // 结束条件
        if (list.size() == nums.length) {
            ans.add(new LinkedList<>(list));
            return;
        }
        // 进入循环
        for (int i = 0; i < nums.length; i++) {
            if (map[i]) {
                continue;
            }
            // 设置当前条件
            map[i] = true;
            list.add(nums[i]);
            // 进入下一层
            backPermute(list);
            list.removeLast();
            // 条件回弹
            map[i] = false;
        }
    }
}
