package com.leetcode.exam;

import java.util.*;

/**
 * 华为机试2
 *
 * 统计字符串中的个数  输出按先多后少  相等的先小写后大写
 *
 */
public class huawei2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            Map<Character, Integer> map = new TreeMap<>();
            char[] chars = in.nextLine().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            List<List<String>> list = new ArrayList<>();
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                List<String> subList = new ArrayList<>(2);
                subList.add(String.valueOf(entry.getKey()));
                subList.add(String.valueOf(entry.getValue()));;
                list.add(subList);
            }
            Collections.sort(list, (t1, t2) -> {
                Integer v1 = Integer.valueOf(t1.get(1));
                Integer v2 = Integer.valueOf(t2.get(1));
                if (v1 == v2) {
                    char c1 = t1.get(0).charAt(0);
                    char c2 = t2.get(0).charAt(0);
                    if ('A' <= c1 && c1 < 'Z' && 'a' <= c2 && c2 <= 'z' ) {
                        return -1;
                    } else if ('A' <= c2 && c2 < 'Z' && 'a' <= c1 && c1 <= 'z') {
                        return -1;
                    }
                    return Character.valueOf(c1).compareTo(Character.valueOf(c2));
                }
                return v2.compareTo(v1);
            });
            list.forEach(v ->
                    System.out.print(v.get(0) + ":" + v.get(1) + ";"));
        }

    }
}
