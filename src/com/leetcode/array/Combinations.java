package com.leetcode.array;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        // 滑动窗口  都不需要变动窗口大小
        ArrayList<List<Integer>> list = new ArrayList<>();
        int r = k, l = 0;
        while (r < n) {
            ArrayList<Integer> subList = new ArrayList<>();
            for (int i = l; i < r; i++) {
                subList.add(i);
            }



            r++;
        }
        for (int i = 0; i < n; i++) {



        }


        return null;
    }
}
