package io.wangsheng.problems;

import io.wangsheng.problems.need.TreeNode;

import java.util.ArrayList;

/**
 * topic: [897].递增顺序搜索树
 * description: 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * difficulty: 简单
 * tags: 二叉树，中序遍历
 * author: wangSheng
 */
public class IncreasingBST {

    ArrayList<Integer> ans;

    public TreeNode increasingBST(TreeNode root) {
        ans = new ArrayList<>();
        helper(root);
        return build();
    }

    // 帮助进行中序遍历二叉搜索树
    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        ans.add(root.val);
        helper(root.right);
    }

    // 帮助进行构建偏掉的二叉树
    public TreeNode build() {
        TreeNode head = new TreeNode();
        TreeNode cur = head;
        for (Integer val : ans) {
            cur.right = new TreeNode(val);
            cur = cur.right;
        }
        return head.right;
    }
}
