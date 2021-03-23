package io.wangsheng.problems;

import io.wangsheng.problems.need.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * topic: [341].扁平化嵌套列表迭代器
 * description: 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * difficulty: 中等
 * tags: 设计思想，链表，DFS
 * author: wangSheng
 */
public class NestedIterator implements Iterator<Integer> {

    LinkedList<Integer> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>();
        getAll(nestedList);
    }

    // dfs 递归查看列表
    public void getAll(List<NestedInteger> nestedList) {
        for (NestedInteger num : nestedList) {
            if (num.isInteger()) {
                list.add(num.getInteger());
            } else {
                getAll(num.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return list.pop();
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }
}