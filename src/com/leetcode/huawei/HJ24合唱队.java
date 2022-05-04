package com.leetcode.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * HJ24 合唱队
 * 例子：
 * 123 124 125 123 121 是一个合唱队形
 * 123 123 124 122不是合唱队形，因为前两名同学身高相等，不符合要求
 * 123 122 121 122不是合唱队形，因为找不到一个同学，他的两侧同学身高递减。
 *
 * 输入：
 * 8
 * 186 186 150 200 160 130 197 200
 * 输出：
 * 4
 * 说明：
 * 由于不允许改变队列元素的先后顺序，所以最终剩下的队列应该为186 200 160 130或150 200 160 130
 */
public class HJ24合唱队 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        String[] split = in.nextLine().split(" ");
        int length = split.length;
        int[][] dp = new int[length][2];
        // 前n位同学能组成的最大对别
        // 1.找出每一元素左右两边最大降序排列元素个数
        // 在找左边的时候
        // 如果n - 1比 n 小那就直接用 f(n - 1)
        // 如果 n- 1 比n 大 那就比较n - 2 知道为0 说明n 不能为顶点
        // 右边同理
        // f(n) =

        // 设置初值 这里每个元素都是长度为1 便于后面的计算
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        // String类型转换为int
        int[] ints = new int[length];
        Arrays.setAll(ints, i-> Integer.valueOf(split[i]));

        // 这里必须要双层循环  是子序列不是子串 不能只和上一个比 需要遍历找比自己小的
        // 每个顶点的左边最大序列
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (ints[i] > ints[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                }
            }
        }
        // 每个顶点的右边边最大序列
        for (int i = length - 2; i >= 0; i--) {
            for (int j = length - 1; j > i ; j--) {
                if (ints[i] > ints[j]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                }
            }

        }
        // 每个顶点的左右只和就是该顶点的最大合法队列
        int res = 0;
        for (int i = 0; i < length; i++) {
            res = Math.max(res, dp[i][0] + dp[i][1]);
        }

        System.out.print(length - res + 1);
    }
}
