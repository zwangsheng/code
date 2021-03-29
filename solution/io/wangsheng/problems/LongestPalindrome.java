package io.wangsheng.problems;

/**
 * topic: [5].最长回文子串
 * description:给你一个字符串 s，找到 s 中最长的回文子串。
 * difficulty:中等
 * tags:字符串，动态规划，贪心，马拉车，中心扩散
 * author: wangSheng
 */
public class LongestPalindrome {

    // 暴力破解，未能AC
    public String longestPalindrome1(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        // O(n^2)将每种可能性都试过去
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                // 做判断
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = test.length();
                }
            }
        return ans;
    }

    public boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 翻转DP
    public String longestPalindrome2(String s) {
        if (s.equals("")) {
            return "";
        }
        int ansLen = 0;
        int end = 0;
        int len = s.length();
        // reverse 进行字符串翻转
        String rever = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                // 如果对应的上就进行操作
                if (s.charAt(i) == rever.charAt(j)) {
                    // 边界情况的特殊判断
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    // 判断这个对应字符,是不是翻转之前对应的那个
                    if (ansLen < dp[i][j]) {
                        int before = len - 1 - j;
                        if (before + dp[i][j] - 1 == i) {
                            ansLen = dp[i][j];
                            end = i;
                        }
                    }
                }
            }
        }
        return s.substring(end - ansLen + 1, end + 1);
    }

    // 翻转DP的空间优化
    public String longestPalindrome3(String s) {
        if (s.equals("")) {
            return "";
        }
        int ansLen = 0;
        int end = 0;
        int len = s.length();
        String rever = new StringBuilder(s).reverse().toString();
        // 采用了一维数组代替二维数组
        // 由dp的公式可以看出,当前数字只对当前的上一行前一个相对应,所以一行一行迭代就好
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j >= 0; j--) {
                if (s.charAt(i) == rever.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[j] = 1;
                    } else {
                        dp[j] = dp[j - 1] + 1;
                    }
                } else {
                    // 因为是一维数组所以记得要归0
                    dp[j] = 0;
                }
                // 经典判断是不是翻转之前的位置
                if (ansLen < dp[j]) {
                    int before = len - 1 - j;
                    if (before + dp[j] - 1 == i) {
                        ansLen = dp[j];
                        end = i;
                    }
                }
            }
        }
        return s.substring(end - ansLen + 1, end + 1);
    }

    // 暴力破解的时候进行存储,利用空间换取时间
    public String longestPalindrome4(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int ansLen = 0;
        String ans = "";
        for (int len = 1; len <= length; len++) {
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                // 如果发现end超出了范围,就结束,无意义
                if (end >= length) {
                    break;
                }
                // dp[start][end] = dp[start+1][end-1] && s[start] == s[end]
                dp[start][end] = ((len == 1 || len == 2 || dp[start + 1][end - 1]) && (s.charAt(start) == s.charAt(end)));
                // 迭代更新
                if (dp[start][end] && len > ansLen) {
                    ansLen = len;
                    ans = s.substring(start, end + 1);
                }
            }
        }
        return ans;
    }

    // 从后往前进行暴力dp
    public String longestPalindrome5(String s) {
        int len = s.length();
        String ans = "";
        boolean dp[][] = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                // 相同的dp公式
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && ((j - i < 2) || dp[i + 1][j - 1]);
                if (dp[i][j] && ans.length() < j - i + 1) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    // 优化空间结构
    public String longestPalindrome6(String s) {
        int len = s.length();
        String ans = "";
        // 利用一维数组进行，每一次迭代的覆盖
        boolean dp[] = new boolean[len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j >= i; j--) {
                dp[j] = (s.charAt(i) == s.charAt(j)) && ((j - i < 3) || dp[j - 1]);
                if (dp[j] && ans.length() < j - i + 1) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    // 利用中心扩散的思想
    public String longestPalindrome7(String s) {
        // 空值判断
        if (s == null || s.length() == 0) {
            return null;
        }
        int start = 0;
        int end = 0;
        // 选择中心点
        for (int i = 0; i < s.length(); i++) {
            // 因为存在奇偶数的问题，所以最好一起考虑了，然后取最大值
            int len1 = exportHelper(s, i, i);
            int len2 = exportHelper(s, i, i + 1);
            int len = Math.max(len1, len2);
            // 迭代顺便推算起点与终点
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // 扩散函数
    public int exportHelper(String s, int left, int right) {
        // 判断边界条件和继续扩散的条件
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // 这里要注意扩散的方向
            left--;
            right++;
        }
        // 返回最长的长度
        return right - left - 1;
    }

    // TODO 马拉车算法
}
