package io.wangsheng.problems;

import java.util.HashMap;
import java.util.Stack;

/**
 * topic: [20].有效括号
 * description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * difficulty: 简单
 * tags: 字符串，栈
 * author: wangSheng
 */
public class IsValid {
    public boolean isValid1(String s) {
        // 存放映射关系，注意存放的时候右边映射左边
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        Stack<Character> stack = new Stack<>();
        // 入栈匹配
        for (Character chr : s.toCharArray()) {
            // 匹配弹出
            if (!stack.isEmpty() && stack.peek() == map.getOrDefault(chr, '*')) {
                stack.pop();
            }else {
                stack.add(chr);
            }
        }
        // 符合规则则为空
        return stack.isEmpty();
    }
}
