package io.wangsheng.problems;

import io.wangsheng.problems.need.TreeNode;

/**
 * topic: [938].二叉搜索树的范围和
 * description: 给定二叉搜索树的根结点，返回值位于范围之间的所有结点的值的和
 * difficulty: 简单
 * tags: 二叉树，DFS
 * author: wangSheng
 */
public class RangeSumBST {
    // 进行深度优先遍历
    public int rangeSumBST1(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        // 由于是二叉搜索树
        // 所以如果当前的值比最小值小，就没必要往左子树走
        // 如果当前的值比最大值大，就没必要往右子树走
        if (root.val < low) {
            return rangeSumBST1(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST1(root.left, low, high);
        }
        // 在中间的话左右子树都需要遍历
        return root.val + rangeSumBST1(root.left, low, high) + rangeSumBST1(root.right, low, high);
    }
}
