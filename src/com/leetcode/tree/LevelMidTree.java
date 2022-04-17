package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[15,7],[9,20],[3]]
 */
public class LevelMidTree {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 正常的层序遍历 最后翻转list
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(root.val);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Integer val = queue.poll();

        }



        return res;
    }
}

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
