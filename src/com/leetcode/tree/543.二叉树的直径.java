import com.leetcode.common.TreeNode;

/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // 首先要明白几个定义： 什么是直径
        // 直径是任意两个节点间最短路径 然后最大值
        // 使用dfs时的递归，需要想清楚子问题
        // 例如要想求4 -> 3 需要知道 1 -> 3 和 1 -> 4
        // 想要求1 -> 4 需要知道2 -> 4

        // ！！！存在的最大问题是 可能不走刚开始的root
        // 所以需要在子节点遍历的时候就计算出可能的最大值
        searchNode(root);
        return res;

    }

    private int searchNode(TreeNode root) {
        if (root == null) return 0;

        // 前
        int l = searchNode(root.left);
        // 中
        int r = searchNode(root.right);
        // 后
        // 最后加1 是加根节点  4 2 5  
        // 4 -> 2 是1   2 -> 5 是1  所以2的最大深度是1 + 1 + 1
       
        // 这一步是为了避免只有根节点的情况
        res = Math.max(res, l + r);

        // 返回是没问题的
        return Math.max(l, r) + 1;

    }

}
// @lc code=end

