package com.leetcode.dp;

/**
 * leecode 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 */
public class LT32最长有效括号 {
    public static void main(String[] args) {
        System.out.print(longestValidParentheses(")()())"));
    }

    public static int longestValidParentheses(String s) {
        // 动态规划
        if (s == null || s.length() == 0 || s.length() == 1) return 0;

        int res = 0;
        int[] dp = new int[s.length()];
        dp[0] = 0; // 长度为0时
        dp[1] = 0; // 只有1个字符时也是0
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                // 这是的情况比较复杂  需要判断上一个是 ( 或者 )
                if (s.charAt(i -1) == '(') {
                    if (i >= 2)
                        dp[i] = dp[i - 2] + 2;
                    else
                        dp[i] = 2; // 这里是长度 所以是2 不是组成多少对括号 注意审题！！
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // 这里的判断 大于零说明之前可以组成括号
                    if ((i - dp[i - 1]) >= 2)
                        dp[i] = dp[i - 1] +  dp[i - dp[i - 1] - 2]  + 2;
                    else
                        dp[i] = dp[i - 1] + 2;
                }
                res = Math.max(res, dp[i]);
            }
            // 这里的判断取消 是因为 不是说1 - i 能组成的最大  最值在中间已经取到了
            //else {
                // 当等于 ( 那必须 上一个是一个完整的才行
            //    dp[i] = dp[i - 1];
          //  }
        }

        return res;
    }
}
