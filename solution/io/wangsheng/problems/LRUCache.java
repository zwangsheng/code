package io.wangsheng.problems;

import java.util.HashMap;

/**
 * topic: [146].LRU缓存机制
 * description: 实现 LRUCache 类
 * difficulty: 中等
 * tags: LRU，链表，哈希，设计
 * author: wangSheng
 */
public class LRUCache {
    // 为了达到O(1)的查询，使用自定义的双向节点
    private static class LinkNode{
        int key;
        int value;
        LinkNode pre;
        LinkNode next;

        public LinkNode(int key, int value){
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }

    // 这样子找寻节点的时候最快
    HashMap<Integer, LinkNode> map;
    Integer capacity;
    // 头节点和尾结点
    LinkNode head;
    LinkNode tail;

    // 初始化创建双向链表
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LinkNode(-1, -1);
        tail = new LinkNode(-1, -1);
        map = new HashMap<>();

        // 头尾相连
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        // 先判断有没有
        if(!map.containsKey(key))
            return -1;
        // 找到节点
        LinkNode node = map.get(key);
        // 断开前后连接
        node.pre.next = node.next;
        node.next.pre = node.pre;
        // 刷新
        move2last(node);
        return node.value;
    }

    public void put(int key, int value) {
        // 通过get找，顺便刷新，更改value
        if(get(key)!=-1){
            map.get(key).value = value;
            return ;
        }
        // 新建节点
        LinkNode node = new LinkNode(key, value);
        map.put(key, node);
        move2last(node);
        // 判断需不需要移除最长未访问节点
        if(map.size()>capacity){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
    }

    public void move2last(LinkNode node){
        node.pre = tail.pre;
        tail.pre = node;
        node.pre.next = node;
        node.next = tail;
    }
}
