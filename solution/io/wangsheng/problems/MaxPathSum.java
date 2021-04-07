package io.wangsheng.problems;

import io.wangsheng.problems.need.TreeNode;

/**
 * topic: [124].二叉树中的最大路径和
 * description: 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * difficulty: 困难
 * tags: 二叉树，递归
 * author: wangSheng
 */
public class MaxPathSum {
    int ans;
    // 利用递归的思想进计算
    public int maxPathSum(TreeNode root) {
        this.ans = Integer.MIN_VALUE;
        helper(root);
        return ans;
    }

    public int helper(TreeNode root) {
        // 空节点返回0
        if (root == null) {
            return 0;
        }
        // 如果小于0，就当没有这个子树
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        // 计算以当前节点为根节点的路径
        int profile = root.val + left + right;

        // 更新结果
        ans = Math.max(ans, profile);
        // 返回自己的贡献，作用主要体现在返回左子树或者右子树的贡献
        return root.val + Math.max(left, right);
    }
}
