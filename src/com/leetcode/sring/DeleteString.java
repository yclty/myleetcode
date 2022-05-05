package com.leetcode.sring;

import java.util.*;

/**
 * HJ23 删除字符串中出现次数最少的字符
 */
public class DeleteString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        int minVal = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char c : line.toCharArray()) {
            Integer count = map.get(c);

            if (count == null) {
                count = 0;
            }
            map.put(c, ++count);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            minVal = Math.min(minVal, entry.getValue());
        }
        ArrayList<Character> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(minVal)) {
                list.add(entry.getKey());
            }
        }
        for (char c : line.toCharArray()) {
            if (!list.contains(c)) {
                System.out.print(c);
            }
        }

    }

}
