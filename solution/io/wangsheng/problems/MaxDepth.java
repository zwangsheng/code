package io.wangsheng.problems;

import io.wangsheng.problems.need.TreeNode;

/**
 * topic: [104].二叉树的最大深度
 * description: 给定一个二叉树，找出其最大深度。
 * difficulty: 简单
 * tags: 二叉树，递归
 * author: wangSheng
 */
public class MaxDepth {
    int max;
    // 进行递归探寻最深处
    public int maxDepth1(TreeNode root) {
        max = 0;
        if(root == null) {
            return 0;
        }
        helper(root, 1);
        return max;
    }

    public void helper(TreeNode root, int count) {
        // 坐到叶子结点进行结算深度，进行迭代结果
        if (root.left == null && root.right == null) {
            if (count > max) {
                max = count;
            }
        }
        if(root.left != null) {
            helper(root.left, count+1);
        }
        if(root.right != null) {
            helper(root.right, count+1);
        }
    }
}
