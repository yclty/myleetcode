package com.leetcode.huawei;

import java.util.Scanner;

/**
 * HJ108 求最小公倍数
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 *
 * 数据范围：1 \le a,b \le 100000 \1≤a,b≤100000
 * 输入：
 * 5 7
 * 复制
 * 输出：
 * 35
 */
public class HJ108求最小公倍数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");

        int m = Integer.valueOf(split[0]);
        int n = Integer.valueOf(split[1]);

        // 10 4 -> 20
        // m * n / 最大公约数
        int mn = m * n;

        // 辗转相除法
        while (n != 0) {
            int temp = m % n ;// 直到能整除
            m = n;
            n = temp;
        }


        System.out.println(mn / m);
    }
}
