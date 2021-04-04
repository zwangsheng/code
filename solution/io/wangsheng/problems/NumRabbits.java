package io.wangsheng.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * topic: [781].颠倒二进制位
 * description: 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 * difficulty: 中等
 * tags: 贪心，哈希
 * author: wangSheng
 */
public class NumRabbits {

    public int numRabbits1(int[] answers) {
        // 把提出相同数量的假设成一个颜色
        // 统计个数
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : answers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        // 利用贪心进行计算
        // 可能存在13个兔子讲5个别的兔子和我一样颜色的情况，所以要进行贪心演算，尽量少的推出颜色的种类
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int y = entry.getKey();
            int x = entry.getValue();
            ans += (x + y) / (y + 1) * (y + 1);
        }
        return ans;
    }
}
