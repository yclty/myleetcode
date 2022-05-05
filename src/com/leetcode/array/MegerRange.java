package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 074. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 */
public class MegerRange {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // 区间按左界排序
        List<int[]> resList = new ArrayList<>();
        int[] pre = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int preLeft = pre[0], preRight = pre[1];
            int curLeft = cur[0], curRight = cur[1];
            if (preRight >= curLeft) { // 发生合并，暂时不放入res中
                pre = new int[]{preLeft, Math.max(preRight, curRight)};
            } else {
                resList.add(pre); // pre与cur未发生合并，将pre放入res中
                pre = cur;
            }
        }
        resList.add(pre); // 无论最后两个区间是否发生合并，剩余未加入res的区间都是pre
        return resList.toArray(new int[resList.size()][]);
    }

}
