package io.wangsheng.problems;

import io.wangsheng.problems.need.DicTreeNode;

/**
 * topic: [14].最长公共前缀
 * description: 编写一个函数来查找字符串数组中的最长公共前缀。
 * difficulty: 简单
 * tags: 字典树，数组，字符串
 * author: wangSheng
 */
public class LongestCommonPrefix {
    // 利用字典树进行匹配
    public String longestCommonPrefix1(String[] strs) {
        // 特殊判断
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        // 构建字典树
        DicTreeNode root = DicTreeNode.buildTree(strs[0]);
        int min = strs[0].length();
        // 进行迭代匹配，获得最小值
        for (int i = 1; i < strs.length; i++) {
            int num = -1;
            DicTreeNode curr = root;
            for (char c : strs[i].toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    break;
                }
                curr = curr.children[c - 'a'];
                num++;
            }
            min = Math.min(num, min);
        }
        // 切分获得答案
        return min == -1 ? "" : strs[0].substring(0, min + 1);
    }

    // 进行数组的横向匹配
    public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0)
            return "";
        // 讲第一个最为答案
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            // 切割
            ans = ans.substring(0, j);
            // 切没了，直接走
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }
}
