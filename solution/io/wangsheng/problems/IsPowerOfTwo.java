package io.wangsheng.problems;

/**
 * topic: [231].2的幂
 * description: 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 * difficulty: 简单
 * tags: 数学，二进制
 * author: wangSheng
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
    // 二进制方法
    // TODO
}
