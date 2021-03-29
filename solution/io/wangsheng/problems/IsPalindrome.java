package io.wangsheng.problems;

/**
 * topic: [9].回文数
 * description: 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false
 * difficulty: 简单
 * tags: 整数，回文
 * author: wangSheng
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        // 对于特殊情况的直接判断
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int rev = 0;
        // 翻转超过一半之后就停下
        while(x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        // 判断奇偶性的问题
        // 如果是奇数，那么rev应该等于反转后的数字除去中文数
        // 如果是偶数，那么就应该相等
        return rev == x || rev / 10 == x;
    }
}
