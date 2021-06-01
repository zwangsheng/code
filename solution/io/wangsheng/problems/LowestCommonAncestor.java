package io.wangsheng.problems;

import io.wangsheng.problems.need.TreeNode;

/**
 * topic: [235].二叉搜索树的最近公共祖先
 * description: 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * difficulty: 简单
 * tags: 二叉搜索树
 * author: wangSheng
 */
public class LowestCommonAncestor {
    // 进行递归的遍历，判断是不是分布在这个节点的两侧
    // 如果是的话，这个就是最近的公共父节点
    // 如果不是就按照规律进入下层
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
