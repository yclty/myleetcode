package com.leetcode.dfs;

import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *
 */
public class LT698划分为k个相等的子集 {
    class Solution {

        public boolean canPartitionKSubsets(int[] nums, int k) {
            if (k == 1) {
                return true;
            }

            int len = nums.length;
            Arrays.sort(nums);
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % k != 0) {
                return false;
            }
            int target = sum / k;
            if (nums[len - 1] > target) {
                return false;
            }

            int size = 1 << len;
            boolean[] dp = new boolean[size];
            dp[0] = true;
            int[] currentSum = new int[size];
            for (int i = 0; i < size; i++) {
                // 总是基于 dp[i] = true 的前提下进行状态转移
                if (!dp[i]) {
                    continue;
                }

                // 基于当前状态，添加一个数以后
                for (int j = 0; j < len; j++) {
                    if ((i & (1 << j)) != 0) {
                        continue;
                    }
                    int next = i | (1 << j);
                    if (dp[next]) {
                        continue;
                    }
                    if ((currentSum[i] % target) + nums[j] <= target) {
                        currentSum[next] = currentSum[i] + nums[j];
                        dp[next] = true;
                    } else {
                        // 由于数组已经排好序，如果 (currentSum[i] % target) + nums[j] > target，剩下的数就没有必要枚举
                        break;
                    }
                }
            }
            return dp[size - 1];
        }
    }
}
