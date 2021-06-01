package io.wangsheng.problems;

import io.wangsheng.problems.need.TreeNode;

import java.util.ArrayList;

/**
 * topic: [230].二叉搜索树中第k小的元素
 * description: 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * difficulty: 中等
 * tags: 二叉树
 * author: wangSheng
 */
public class KthSmallest {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public int kthSmallest(TreeNode root, int k) {
        // 进行二叉树的遍历，然后返回结果
        fetch(root);
        Integer[] nums = new Integer[list.size()];
        list.toArray(nums);
        return nums[k-1];
    }

    public void fetch (TreeNode node) {
        // 进行先序遍历
        if (node == null) {
            return;
        }
        fetch(node.left);
        list.add(node.val);
        fetch(node.right);
    }
}
