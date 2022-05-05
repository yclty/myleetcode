package com.leetcode.sring;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * HJ33 整数与IP地址间的转换
 * 描述
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 *
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 *
 * 数据范围：保证输入的是合法的 IP 序列
 *
 * 输入描述：
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 *
 * 示例1
 * 输入：
 * 10.0.3.193
 * 167969729
 * 复制
 * 输出：
 * 167773121
 * 10.3.3.193
 */
public class TransIP {

    public static void main(String[] args) throws Exception {
        // 1.高效读数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            String[]  ss =  str.split("\\.");
            System.out.println(Long.parseLong(ss[0]) << 24
                    | Long.parseLong(ss[1]) << 16
                    | Long.parseLong(ss[2]) << 8
                    | Long.parseLong(ss[3])  );
            long num = Long.parseLong(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append((num >> 24 )& 255).append(".")
                    .append((num >> 16) & 255).append(".")
                    .append((num>> 8) & 255).append(".")
                    .append((num & 255));
            System.out.println(sb.toString());

        }

    }

/*
    static long[] ints;
    static {
        ints = new long[32];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (long) Math.pow(2, i);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip = in.nextLine();
        long l = in.nextLong();

        // 十进制转二进制  除二取余法
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : ip.split("\\.")) {
            Integer val = Integer.valueOf(s);
            stringBuilder.append(transTo(val, 8));
        }
        System.out.println(transFrom(stringBuilder.toString()));


        String s = transTo(l, 32).toString();
        // 每隔8位分割后输出对应的点分割的十进制数字

        StringBuilder sb = new StringBuilder();
        for (int i = 8; i <= s.toCharArray().length; i += 8) {
            String substring = s.substring(i - 8, i);
            sb.append(transFrom(substring)).append(".");
        }
        System.out.println(sb.substring(0, sb.length() - 1));

    }

    private static long transFrom(String s) {
        int length = s.length() - 1;
        long res = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if (c == '1') {
                res += ints[length - i];
            }
        }
        return res;
    }

    private static StringBuilder transTo(long val, int length) {
        StringBuilder sb = new StringBuilder();
        while (val > 0) {
            sb.append(val % 2);
            val /= 2;
        }
        sb = sb.reverse();
        int i = length - sb.length();
        if (i > 0) {
            StringBuilder sb1 = new StringBuilder();
            while (i-- > 0) {
                sb1.append("0");
            }
            sb1.append(sb);

            return sb1;
        }  else {
            return sb;
        }
    }*/

}
