package io.wangsheng.problems;

import io.wangsheng.problems.need.TreeNode;

/**
 * topic: [783].二叉搜索树节点最小距离
 * description: 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * difficulty: 简单
 * tags: 二叉树，中序遍历
 * author: wangSheng
 */
public class MinDiffInBST {
    int ans;
    TreeNode pre;
    // 思路就是按照左中右的顺序进行遍历
    // 由于是二叉搜索树。所以答案不可能不在相邻的两个节点之间
    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = null;
        helper(root);
        return ans;
    }

    public void helper(TreeNode root) {
        // 叶子节点无必要
        if (root == null) {
            return;
        }
        helper(root.left);
        // 迭代相邻节点
        if (pre != null) {
            ans = Math.min(ans, root.val - pre.val);
        }
        pre = root;
        helper(root.right);
    }
}
