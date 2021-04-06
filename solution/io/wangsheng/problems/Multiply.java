package io.wangsheng.problems;

/**
 * topic: [43].字符串相乘
 * description: 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * difficulty: 中等
 * tags: 字符串，大数乘法
 * author: wangSheng
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        // 特殊值判断
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        // 存放结果的数组
        int[] ans = new int[len1 + len2];
        // 逆序相乘，存放在对应的位置
        for (int i = len1 - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ans[i + j + 1] += x * y;
            }
        }
        // 对每个存放的数字进行进位处理
        for (int i = len1 + len2 - 1; i >= 1; i--) {
            ans[i - 1] += ans[i] / 10;
            ans[i] %= 10;
        }
        // 判断顶头需不需要进行处理
        int index = (ans[0] == 0) ? 1 : 0;
        StringBuilder sb = new StringBuilder();
        while (index < (len1 + len2)) {
            sb.append(ans[index++]);
        }
        return sb.toString();
    }
}
