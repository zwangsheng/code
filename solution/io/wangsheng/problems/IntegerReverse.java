package io.wangsheng.problems;

/**
 * topic: [7].整数反转
 * description: 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * difficulty: 简单
 * tags: 整数
 * author: wangSheng
 */
public class IntegerReverse {
    int right = 214748364;
    int left = -214748364;
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int num = x % 10;
            // 判断是否上下越界
            if (ans > right || (ans == right && num > 7)) {
                return 0;
            }
            if (ans < left || (ans == left && num < -8)) {
                return 0;
            }
            ans = ans * 10 + num;
            x /= 10;
        }
        return ans;
    }
}
