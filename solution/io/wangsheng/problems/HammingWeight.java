package io.wangsheng.problems;

/**
 * topic: [191].位1的个数
 * description: 输入数字，判断二进制中的1的个数
 * difficulty: 简单
 * tags: 位运算
 * author: wangSheng
 */
public class HammingWeight {
    // n & 1 判断当前位是否为1
    // n >>> 1 逻辑右移，下一位
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    // n & (n - 1) 可以消除最后一个1
    // 那么就可以根据变成0之前消了几次来判断有几个1
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
