package io.wangsheng.problems.need;

public class DicTreeNode {
    public char val;
    public DicTreeNode[] children = new DicTreeNode[27];

    public DicTreeNode() {

    }

    public DicTreeNode(char c) {
        val = c;
    }

    public static DicTreeNode buildTree(String str) {
        DicTreeNode head = new DicTreeNode();
        DicTreeNode index = head;
        for (char c : str.toCharArray()) {
            DicTreeNode cur = new DicTreeNode(c);
            index.children[c - 'a'] = cur;
            index = cur;
        }
        return head;
    }
}
