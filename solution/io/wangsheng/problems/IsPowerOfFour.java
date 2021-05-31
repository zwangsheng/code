package io.wangsheng.problems;
/**
 * topic: [342].4的幂
 * description: 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * difficulty: 简单
 * tags: 数学，幂，二进制
 * author: wangSheng
 */
public class IsPowerOfFour {

    // 利用数学特性
    // 如果是4的幂次方
    // 那么必定是2的幂次方
    // 所以先判断是不是2的幂次方git
    // 然后判断能否除以3余1
    public boolean isPowerOfFour(int n) {
        return (n & (n - 1)) == 0 && n % 3 == 1;
    }
    // 还有二进制的解决办法
    // TODO
}
