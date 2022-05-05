package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 994. 腐烂的橘子
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 *
 */
public class LT994腐烂的橘子 {


    public int orangesRotting(int[][] grid) {
        // bfs

        Queue<int[]> queue = new LinkedList<>();

        int goodCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    goodCount++;
                }
            }
        }
        int res = 0;
        while (goodCount > 0 && !queue.isEmpty()) { // 这里注意goodCount > 0 的判断
            res++;
            for (int i = 0; i < queue.size(); i++) {
                int[] poll = queue.poll();
                int h = poll[0]; // 行
                int l = poll[1]; // 列

                // 对所有节点的上下左右 进行一次污染
                if (h - 1 >= 0)
                if (grid[h - 1][l] == 1) {
                    grid[h - 1][l] = 2;
                    goodCount--;
                    queue.offer(new int[]{h - 1, l});
                }
                if (h + 1 < grid.length)
                if (grid[h + 1][l] == 1) {
                    grid[h + 1][l] = 2;
                    goodCount--;
                    queue.offer(new int[]{h + 1, l});
                }
                if (l - 1 >= 0)
                if (grid[h][l - 1] == 1) {
                    grid[h][l - 1] = 2;
                    goodCount--;
                    queue.offer(new int[]{h, l - 1});
                }
                if (l + 1 < grid[0].length)
                if (grid[h][l + 1] == 1) {
                    grid[h][l + 1] = 2;
                    goodCount--;
                    queue.offer(new int[]{h, l + 1});
                }

            }

        }

        return goodCount != 0 ? -1 : res;
    }
}
