package com.leetcode.huawei;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * HJ68 成绩排序
 * 描述
 * 给定一些同学的信息（名字，成绩）序列，请你将他们的信息按照成绩从高到低或从低到高的排列,相同成绩
 *
 * 都按先录入排列在前的规则处理。
 *
 * 例示：
 * jack      70
 * peter     96
 * Tom       70
 * smith     67
 *
 * 从高到低  成绩
 * peter     96
 * jack      70
 * Tom       70
 * smith     67
 *
 * 从低到高
 *
 * smith     67
 *
 * jack      70
 *
 * Tom       70
 * peter     96
 *
 * 注：0代表从高到低，1代表从低到高
 *
 */
public class HJ68成绩排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer count = Integer.valueOf(in.nextLine());
        boolean sort= Integer.valueOf(in.nextLine()) == 1;
        ArrayList<String> list = new ArrayList<>();
        TreeMap<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < count; i++) {
            list.add(in.nextLine());
        }
        list.stream().sorted((v1, v2) -> sort ?
                Integer.valueOf(v1.split(" ")[1]).compareTo(Integer.valueOf(v2.split(" ")[1])) :
                Integer.valueOf(v2.split(" ")[1]).compareTo(Integer.valueOf(v1.split(" ")[1]))).
                collect(Collectors.toList()).stream().forEach(t ->
                        System.out.println(t)
                );
    }
}
