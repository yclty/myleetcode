package com.leetcode.exam;

import java.util.*;

/**
 * 组合问题 dfs暴力破解
 */
public class huawei3 {
    static List<List<String>> res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            Integer length = Integer.valueOf(in.nextLine());
            String[] split = in.nextLine().split(" ");

            boolean[] visited = new boolean[length];
            LinkedList<String> list = new LinkedList<>();
            res = new ArrayList<>();
            // dfs递归
            dfs(split, list, visited);

            TreeSet<String> set = new TreeSet<>();
            for (List<String> re : res) {
                StringBuilder sb = new StringBuilder();
                re.forEach(str -> sb.append(str));
                set.add(sb.toString());
            }
            set.forEach(str -> System.out.println(str));
        }

    }

    static void dfs(String[] array, LinkedList<String> track, boolean[] visited) {
        if (track.size() == array.length) {
            // 挑完了全部元素
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < array.length; i++) {
            // 排除自己
            if (visited[i]) {
                continue;
            }
            String s = array[i];

            visited[i] = true;
            track.add(s);
            dfs(array, track, visited);

            // 撤销选择
            track.removeLast();
            visited[i] = false;
        }

    }
}
