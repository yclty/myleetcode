package com.leetcode.huawei;

import java.lang.management.MemoryType;
import java.util.Scanner;

/**
 * HJ32 密码截取
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，
 * 比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。
 * 比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。
 * 因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），
 * Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 *
 * 输入：
 * ABBA
 * 输出：
 * 4
 */

public class HJ32密码截取 {
    // 最长回文子串？
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int length = line.length();
        // 还在想怎么表示start 和 end  ？
        // 完全可以用dp[i][j]表示对应的开始结束表示是否回文子串
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 1; i < length; i++) {
            char c = line.charAt(i);
            for (int j = 0; j < i; j++) {
                char c1 = line.charAt(j);
                if (i - j < 3) {
                    dp[i][j] = c == c1;
                } else {
                    // abb   a/b/c
                    // bab   a/b/c
                    // 如果 i == j  且 j+1  i-1 是回文则是
                    dp[i][j] =
                            c == c1 && dp[i - 1][j + 1];

                }
                if (dp[i][j] && i - j + 1 > max) {
                    //System.out.println(line.substring(j , i + 1));
                    max = Math.max(max, i - j + 1);
                    max = i - j;
                    start = j;
                    end = i;
                }

            }
        }


        System.out.print(max);
    }


}
