package com.leetcode.huawei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * HJ43 迷宫问题
 * 定义一个二维数组 N*M ，如 5 × 5 数组下所示：
 *
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,
 * };
 *
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，
 * 要求编程序找出从左上角到右下角的路线。入口点为[0,0],既第一格是可以走的路。
 */
public class HJ43迷宫问题_DFS {
    private static LinkedList<int[]> res = new LinkedList<>();
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        // dfs回溯 / bfs
        Scanner in = new Scanner(System.in);
        String[] lentgh = in.nextLine().split(" ");
        int[][] ints = new int[Integer.valueOf(lentgh[0])][Integer.valueOf(lentgh[1])];

        long start = System.currentTimeMillis();
        for (int i = 0; i < Integer.valueOf(lentgh[0]); i++) {
            String[] s = in.nextLine().split(" ");
            Arrays.setAll(ints[i], j -> Integer.valueOf(s[j]));
        }

        boolean[][] visited = new boolean[ints.length][ints[0].length];
        visited[0][0] = true;

        LinkedList<int[]> track = new LinkedList();
        track.add(new int[]{0, 0});
        dfs(ints,track , visited);

        // 输出结果
        res.forEach(array -> {
            StringBuilder sb = new StringBuilder("(");
            sb.append(array[0]).append(",").append(array[1]).append(")");
            System.out.println(sb);
        });
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void dfs (int[][] ints, LinkedList<int[]> track, boolean[][] visited) {
        // 判断条件 如果当前坐标是是右下角就终止
        // 注意！！数据保证有唯一解 说明不会死循环 但是需要比较最小路径 就需要回溯
        if (track.size() == 0) return; // 该路无解

        if (track.getLast()[0] == ints.length - 1 &&  track.getLast()[1] == ints[0].length - 1) {
          //  System.out.println(track.size());
            if (track.size() < min) {
                min = track.size();
                res = new LinkedList<>(track);
            }
            // 到终点了 需要记录值
            // 判断最大值
            return;
        }

        // 做选择
        for (int i = 0; i < track.size(); i++) {
            int[] grid = track.get(i);
            int h = grid[0];
            int l = grid[1];
            // 从一个点出发 可以有上下左右 四个点选择 但是不能走回头路 且不能为路可以走 就是 val = 0
            LinkedList<int[]> list = new LinkedList<>();


            if (h + 1 < ints.length &&
                    !visited[h + 1][l] &&
                    ints[h + 1][l] == 0) {
                list.add(new int[]{h + 1, l});
            }
            if (h - 1 >= 0 &&
                    !visited[h - 1][l] &&
                    ints[h - 1][l] == 0) {
                list.add(new int[]{h - 1, l});
            }
            if (l + 1 < ints[0].length &&
                    !visited[h][l + 1] &&
                    ints[h][l + 1] == 0) {
                list.add(new int[]{h, l + 1});
            }
            if (l - 1 >= 0 &&
                    !visited[h][l - 1] &&
                    ints[h][l - 1] == 0) {
                list.add(new int[]{h, l - 1});
            }

            for (int[] ints1 : list) {
                track.add(ints1);
                visited[ints1[0]][ints1[1]] = true;

                // 递归
                dfs(ints, track, visited);

                // 撤销选择
                track.removeLast();
                visited[ints1[0]][ints1[1]] = false;
            }




        }




    }


}
