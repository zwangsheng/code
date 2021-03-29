package io.wangsheng.problems;

/**
 * topic: [190].颠倒二进制位
 * description: 颠倒给定的 32 位无符号整数的二进制位。
 * difficulty: 简单
 * tags: 二进制
 * author: wangSheng
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int ans = 0;
        // 定死了32位
        for (int i = 0; i < 32 && n != 0; i++) {
            // 一个一个判断，左移到对应的位置
            ans |= (n & 1) << (31 - i);
            // 注意无符号，所以逻辑右移
            n >>>= 1;
        }
        return ans;
    }
}
