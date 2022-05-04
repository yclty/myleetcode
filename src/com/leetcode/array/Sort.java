package com.leetcode.array;

import java.util.Random;
import java.util.Scanner;

/**
 * HJ101 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 *
 * 描述
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 *
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000  ，元素大小满足 0 \le val \le 100000 \0≤val≤100000
 * 输入描述：
 * 第一行输入数组元素个数
 * 第二行输入待排序的数组，每个数用空格隔开
 * 第三行输入一个整数0或1。0代表升序排序，1代表降序排序
 *
 * 示例1
 * 输入：
 * 8
 * 1 2 4 9 3 55 64 25
 * 0
 * 复制
 * 输出：
 * 1 2 3 4 9 25 55 64
 */
public class Sort {
    static boolean sort;
    static int[] res;

    public static void main(String[] args) {
        // 快排
        Scanner in = new Scanner(System.in);
        res = new int[Integer.valueOf(in.nextLine())];
        String str = in.nextLine();
        sort =  in.nextInt() == 1;

        String[] array = str.split(" ");
        for (int i = 0; i < array.length; i++) {
            res[i] = Integer.valueOf(array[i]);
        }
        // 大体思想就是 选取一个随机位置的数 把小的放左边  大的放右边  递归排序
        sort(0, res.length - 1);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    /**
     * 快排的核心代码
     * @param l
     * @param r
     */
    private static void sort(int l, int r) {
        if (l >= r) return;

        int start = l;
        int i = new Random().nextInt(r - l) + l;
        swap1(i , r);

        // 一定要注意这里不是二分  是随机选中一个位置
        // 先把这个数放到最后 移动最后放置的指针
        // 全部比较完毕后 把这个位置和最后位置换回来 然后 递归
        int point = l;
        int target = res[r];
        while (l < r) {
            // sort true 升序 ： 降序
            if (sort ? res[l] > target : res[l] < target) {
                swap1(l, point++);
            }
            l++;
        }
        // 换回来 point虚拟指针
        swap1(point, r);

        sort(start, point - 1);
        sort(point + 1, r);

    }



  /*  public static void main(String[] args) {
        /// 冒泡
        Scanner in = new Scanner(System.in);
        res = new int[Integer.valueOf(in.nextLine())];
        String str = in.nextLine();
        sort =  in.nextInt() == 1;

        String[] array = str.split(" ");
        for (int i = 0; i < array.length; i++) {
            res[i] = Integer.valueOf(array[i]);
        }

        for (int i = 1; i < res.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(i, j);
            }

        }
        for (int re : res) {
            System.out.print(re + " ");
        }
    }*/

    private static void swap1 (int i, int  j) {
        if (i == j) return;
        int temp = res[i];
        res[i] = res[j];
        res[j] = temp;

    }

    private static void swap (int i, int  j) {
       if (sort && res[i] < res[j] || (!sort && res[i] > res[j])) return;

        int temp = res[i];
        res[i] = res[j];
        res[j] = temp;

    }

}
