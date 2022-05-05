package com.leetcode.tree;

import com.leetcode.common.TreeNode;
/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        maxPath(root);
        return res;
    }

    private int maxPath(TreeNode root) {
        if (root == null) return 0;

        // 由于负数的存在，一个数加负数 必然比加+ 小 由此可以得出
        // maxL  maxR 如果存在负数就直接加0
        // 前
        int maxL = Math.max(maxPath(root.left), 0);
        // 中
        int maxR = Math.max(maxPath(root.right), 0);
        // 后

        // dengy
        res = Math.max(res, maxL + maxR +root.val);


        return root.val + Math.max(maxL , maxR);
    }
}
// @lc code=end

