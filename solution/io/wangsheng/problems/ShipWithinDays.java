package io.wangsheng.problems;

import java.util.Arrays;

/**
 * topic: [1011].在D天内送达包裹的能力
 * description: 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * difficulty: 中等
 * tags: 二分查找，数组
 * author: wangSheng
 */
public class ShipWithinDays {

    public int shipWithinDays(int[] weights, int D) {
        // 做空值判断
        if (weights.length == 0) {
            return 0;
        }
        // 作二分查找的算法
        // 左边界是数组的最大值
        // 右边界是数组的和
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        // 二分查找
        while (left < right) {
            int mid = (left + right) / 2;
            int need = 1;
            int cur = 0;
            // 计算天数
            // 累加，迭代天数
            for (int weight : weights) {
                if (cur + weight > mid) {
                    need++;
                    cur = 0;
                }
                cur += weight;
            }
            // 利用天数进行计算
            // 天数太少了就降低负载
            // 天数太多了就提高负载
            if (need <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 最终逼在一起
        return left;
    }
}
