package io.wangsheng.problems;

import io.wangsheng.problems.need.TreeNode;

import java.util.LinkedList;

/**
 * topic: [173].二叉搜索树迭代器
 * description: 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器
 * difficulty: 中等
 * tags: 二叉树，设计
 * author: wangSheng
 */
public class BSTIterator {
    // 用来存放二叉树的中序序遍历结果
    LinkedList<Integer> list;

    // 二叉搜索树的顺序便利就是二叉树的中序遍历
    public BSTIterator(TreeNode root) {
        list = new LinkedList<>();
        getList(root);
    }

    // 中序遍历
    private void getList(TreeNode root) {
        if (root == null) {
            return;
        }
        getList(root.left);
        list.add(root.val);
        getList(root.right);
    }

    public int next() {
        return list.pop();
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
