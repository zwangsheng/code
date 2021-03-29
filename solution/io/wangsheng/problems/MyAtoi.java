package io.wangsheng.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * topic: [8].字符串转换成整数
 * description: 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * difficulty: 中等
 * tags: 字符串，状态机
 * author: wangSheng
 */
public class MyAtoi {

    // 符号
    public int sign = 1;
    // 结果
    public long ans = 0L;
    // 当前状态
    private String state = "start";
    // 状态对应的列表，是个4*4的表格
    private final Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    // 判断当前字符
    public void get(char c) {
        // 获取到进入的状态
        state = table.get(state)[get_col(c)];
        // 输入数字的状态
        if ("in_number".equals(state)) {
            // 进入累加
            ans = ans * 10 + c - '0';
            // 进行边界值和符号的判断
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            // 进行符号的判断
            sign = c == '+' ? 1 : -1;
        }
    }

    // 按照当前的状态和目前需要判断的字符进行判断下一步需要进入的状态
    public int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '-' || c == '+') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }

    public int myAtoi(String s) {
        MyAtoi automaton = new MyAtoi();
        for (char c : s.toCharArray()) {
            automaton.get(c);
        }
        return (int) (automaton.sign * automaton.ans);
    }
}
