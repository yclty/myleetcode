package com.leetcode.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 华为机试1 给一个字符串中的数字 统计整数最小和
 * 可能包含 - 即负号
 * asdf123sadfa-12as
 * 1 + 2 + 3 - 12
 *
 */
public class huawei1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            // bb12-34aa
            char[] chars = in.nextLine().toCharArray();
            int length = chars.length;
            ArrayList<List<Integer>> list = new ArrayList<>();
            int res = 0;

            for (int i = 0; i < length; i++) {
                char c = chars[i];

                if ('0' <= c && c <= '9') {
                    res += c - '0';
                } else if (c == '-') {
                    // 如果有负数  就取最小负数  并且正数都取最小
                    ArrayList<Integer> suList = new ArrayList<>();
                    i++;
                    while (i < length) {
                        char c1 = chars[i];
                        if ('0' <= c1 && c1 <= '9') {
                            suList.add(c1 - '0');
                        } else {
                            i--;
                            break;
                        }
                        i++;
                    }
                    if (!suList.isEmpty()) {
                        list.add(suList);
                    }

                }

            }

            if (!list.isEmpty()) {
                for (List<Integer> integers : list) {
                    int size = integers.size();
                    int sum = 0;
                    for (int i = 0; i < size; i++) {
                        Integer integer = integers.get(i);
                        int j = size - 1 - i;
                        while (j-- > 0) {
                            integer *= 10;
                        }
                        sum += integer;
                    }
                    res += -sum;
                }
            }
            System.out.println(res);
        }
    }
}
