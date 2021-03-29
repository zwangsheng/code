package io.wangsheng;

public class Main {
    public static void main(String[] args) {
        longestCommonPrefix(new String[]{"flower","flow","flight"});
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        DicTreeNode root = DicTreeNode.buildTree(strs[0]);
        int min = strs[0].length();
        for (int i = 1; i< strs.length; i++) {
            int num = -1;
            DicTreeNode curr = root;
            for (char c : strs[i].toCharArray()) {
                if (curr.children[c-'a'] == null) {
                    break;
                }
                curr = curr.children[c-'a'];
                num++;
            }
            min = Math.min(num, min);
        }
        return min == -1 ? "" : strs[0].substring(0, min + 1);
    }

    static class DicTreeNode {
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
                index.children[c-'a'] = cur;
                index = cur;
            }
            return head;
        }
    }
}
