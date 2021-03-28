package io.wangsheng.problems;

import io.wangsheng.problems.need.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * topic: [94].二叉树的中序遍历
 * description: 给定一个二叉树的根节点 root ，返回它的 中序 遍历
 * difficulty: 中等
 * tags: 二叉树
 * author: wangSheng
 */
public class InorderTraversal {
    List<Integer> ans;
    public List<Integer> inorderTraversal1(TreeNode root) {
        ans = new LinkedList<>();
        return ans;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);
        ans.add(root.val);
        helper(root.right);
    }
}
