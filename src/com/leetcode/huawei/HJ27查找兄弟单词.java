package com.leetcode.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * HJ27 查找兄弟单词
 * 描述
 * 定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
 * 现在给定你 n 个单词，另外再给你一个单词 x ，让你寻找 x 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
 * 注意：字典中可能有重复单词。
 * 示例1
 * 输入：
 * 3 abc bca cab abc 1
 * 复制
 * 输出：
 * 2
 * bca
 *
 */
public class HJ27查找兄弟单词 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int length = split.length;
        int res = Integer.valueOf(split[length - 1]);
        String[] array = new String[Integer.valueOf(split[0])];
        for (int i = 1; i < length - 2; i++) {
            array[i - 1] = split[i];
        }
        String target = split[length - 2];
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : target.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        ArrayList<String> list = new ArrayList<>();
        loop1: for (String s : array) {
            if (s.length() == target.length() && !s.equals(target)) {
                HashMap<Character, Integer> temp = new HashMap<>();
                temp.putAll(map);
                for (char c : s.toCharArray()) {
                    Integer val = temp.get(c);
                    if (val == null || val <= 0) continue loop1;
                    temp.put(c, --val);
                }
                if (temp.values().stream().allMatch(t -> t == 0)) {
                    list.add(s);
                }
            }
        }
        String out = "";
        Collections.sort(list);
        if (list.size() > res - 1) {
            out = list.get(res - 1);
        }
        System.out.println(list.size());
        System.out.print(out);
    }

}
