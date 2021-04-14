package io.wangsheng.problems;

/**
 * topic: [208].实现Trie(前缀树)
 * description: Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * difficulty: 中等
 * tags: 字典树，设计
 * author: wangSheng
 */
public class Trie {
    // 内置的前缀树节点
    static class Node {
        boolean end = false;
        Node[] children = new Node[26];
    }

    // 指向头部
    Node head;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        head = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        // 添加字符串的时候要注意之前存在了节点不能被覆盖
        Node cur = head;
        for (Character chr : word.toCharArray()) {
            // 先判断之前有无字符，有的话要保留那条路径
            if (cur.children[chr - 'a'] == null) {
                cur.children[chr - 'a'] = new Node();
            }
            cur = cur.children[chr - 'a'];
        }
        cur.end = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        // 完整查询需要判断最终节点有无结束标志
        Node cur = head;
        for (Character chr : word.toCharArray()) {
            if (cur.children[chr - 'a'] == null) {
                return false;
            }
            cur = cur.children[chr - 'a'];
        }
        // 结果是结束标志，不然就是前缀
        return cur.end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node cur = head;
        for (Character chr : prefix.toCharArray()) {
            if (cur.children[chr - 'a'] == null) {
                return false;
            }
            cur = cur.children[chr - 'a'];
        }
        // 只要有就行，无需判断是否结束
        return true;
    }
}
