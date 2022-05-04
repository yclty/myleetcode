package com.leetcode.huawei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
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
public class HJ43迷宫问题_BFS {
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

        int count = 0;
        Queue<Node> queue = new LinkedList<>();

        Node root = new Node(null, 0, 0);
        queue.offer(root);

        loopWhile: while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node grid = queue.poll();
               // res.add(grid);

                int h = grid.i;
                int l = grid.j;
                if (h == ints.length - 1 && l == ints[0].length - 1) {
 //                   System.out.println(queue.size());
                    // 只能将之前的左边 按照树去构建 然后倒序输入路径
                    root = grid;
                    break loopWhile;
                }

                // 从一个点出发 可以有上下左右 四个点选择 但是不能走回头路 且不能为路可以走 就是 val = 0
                LinkedList<int[]> list = new LinkedList<>();
                if (h + 1 < ints.length &&
                        !visited[h + 1][l] &&
                        ints[h + 1][l] == 0) {
                    queue.offer(new Node(grid, h + 1, l));
                }
                if (h - 1 >= 0 &&
                        !visited[h - 1][l] &&
                        ints[h - 1][l] == 0) {
                    queue.offer(new Node(grid, h - 1, l));
                }
                if (l + 1 < ints[0].length &&
                        !visited[h][l + 1] &&
                        ints[h][l + 1] == 0) {
                    queue.offer(new Node(grid, h, l + 1));
                }
                if (l - 1 >= 0 &&
                        !visited[h][l - 1] &&
                        ints[h][l - 1] == 0) {
                    queue.offer(new Node(grid, h, l - 1));
                }
            }
        }

        while (root != null) {
            res.addFirst(new int[]{root.i, root.j});
            root = root.prev;
        }

        // 输出结果
        res.forEach(array -> {
            StringBuilder sb = new StringBuilder("(");
            sb.append(array[0]).append(",").append(array[1]).append(")");
            System.out.println(sb);
        });
     //   System.out.println(System.currentTimeMillis() - start);
    }

    static class Node {
        //int[] val;
        int i;
        int j;
        Node prev;
        public Node(Node prev, int i, int j){
            this.prev = prev;
            this.i = i;
            this.j = j;
        }
       /* public node(node[] nexts) {
            this.prev = this;
            this.nexts = nexts;
        }*/
    }

}
