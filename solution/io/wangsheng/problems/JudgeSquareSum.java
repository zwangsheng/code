package io.wangsheng.problems;

/**
 * topic: [633].平方数之和
 * description: 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * difficulty: 中等
 * tags: 数学，枚举，二分查找
 * author: wangSheng
 */
public class JudgeSquareSum {
    // 枚举，用long免得超了
    public boolean judgeSquareSum1(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            // 判断能不能整净
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    // 二分枚举
    public boolean judgeSquareSum2(int c) {
        // 左边是0开始，右边是平方根开始
        long left = 0;
        long right = (int) Math.sqrt(c);
        while (left <= right) {
            // 判断当前偏向那边
            long num = left * left + right * right;
            if (num == c) {
                return true;
            } else if (num > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    // 数学的方法
    // 费马平方和，不懂
    public boolean judgeSquareSum3(int c) {
        for (int base = 2; base * base <= c; base++) {
            if (c % base != 0) {
                continue;
            }

            int exp = 0;
            while (c % base == 0) {
                c /= base;
                exp++;
            }

            if (base % 4 == 3 && exp % 2 != 0) {
                return false;
            }
        }
        return c % 4 != 3;
    }
}
