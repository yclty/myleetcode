package com.leetcode.huawei;

import java.util.*;

/**
 * HJ28 素数伴侣
 * 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，
 * 它们能应用于通信加密。现在密码学会请你设计一个程序，
 * 从已有的 N （ N 为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，
 * 例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，
 * 而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，
 * 当然密码学会希望你寻找出“最佳方案”。
 *       1
 *    2  3  4
 *
 */
public class HJ28素数伴侣 {

    public static void main(String[] args) {
        // dsf or dp ？
        // 两两配对
        Scanner in = new Scanner(System.in);
        Integer length = Integer.valueOf(in.nextLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : in.nextLine().split(" ")) {
            list.add(Integer.valueOf(s));
        }
        // list中的元素两两配对组成素数的最大 方案
        // 递归两两配对 判断  然后
        dfs(list, new LinkedList<>());

    }

    private static void dfs(List<Integer> list, Deque<Integer> queue) {
        if (queue.size() == 2) {

        }

        for (int i = 0; i < list.size(); i++) {
            // 判断 这里需要跳过已经进来的循环 例如 0

            queue.add(list.get(i));
            // 递归
            dfs(list, queue);

            // 回溯
            queue.removeLast();

        }

    }

}
