package com.leetcode.huawei;

import java.util.*;

/**
 * HJ41 称砝码
 *
 * 描述
 * 现有n种砝码，重量互不相等，分别为 m1,m2,m3…mn ；
 * 每种砝码对应的数量为 x1,x2,x3...xn 。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 *
 *
 * 注：
 *
 * 称重重量包括 0
 *
 * 数据范围：每组输入数据满足 1 \le n \le 10 \1≤n≤10  ， 1 \le m_i \le 2000 \1≤m
 *
 * 输入描述：
 * 对于每组测试数据：
 * 第一行：n --- 砝码的种数(范围[1,10])
 * 第二行：m1 m2 m3 ... mn --- 每种砝码的重量(范围[1,2000])
 * 第三行：x1 x2 x3 .... xn --- 每种砝码对应的数量(范围[1,10])
 *
 * 输入：
 * 2
 * 1 2
 * 2 1
 * 复制
 * 输出：
 * 5
 * 复制
 * 说明：
 * 可以表示出0，1，2，3，4五种重量。
 */
public class HJ41称砝码 {
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length =  Integer.valueOf(in.nextLine());
        String[] types = in.nextLine().split(" ");
        String[] nums = in.nextLine().split(" ");

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < types.length; i++) {
            Integer num = Integer.valueOf(nums[i]);
            while (num-- > 0) {
                list.add(Integer.valueOf(types[i]));
            }
        }
        set.add(0);
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> res = new ArrayList<>();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                Integer next = (Integer)it.next();
                res.add(next + list.get(i));
            }
            set.addAll(res);
        }
        System.out.println(set.size());
    }












    /*static Set set = new HashSet<Integer>();
    public static void main(String[] args) {
        // 1 1 2
        // 11  12  12
        // 1 1 1 1 1
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] types = in.nextLine().split(" ");
        String[] nums = in.nextLine().split(" ");

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < types.length; i++) {
            Integer num = Integer.valueOf(nums[i]);
            while (num-- > 0) {
                list.add(Integer.valueOf(types[i]));
            }
        }
        set.add(0);
       // for (int i = 0; i < list.size(); i++) {
         //   set.add(list.get(i));
            dfs(list, 0, 0);
       // }
        System.out.println(set.size());
    }

    private static void dfs(List<Integer> list, int i, int sum) {

        if (i > list.size() - 1) {
            return ;
        }
        set.add(list.get(i));
//        sum += list.get(i);
        for (int j = 0; j < list.size(); j++) {
            if (i <= j) continue;

            Integer jVal = list.get(j);
            sum += jVal;
            set.add(sum);

          // if (set.contains(sum)) continue;

            dfs(list, i + 1, sum);
            sum -= jVal;

        }

    }
*/
}
