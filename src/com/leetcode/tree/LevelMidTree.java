package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode 107. 二叉树的层序遍历 II
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[15,7],[9,20],[3]]
 */
public class LevelMidTree {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 正常的层序遍历 最后翻转list
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            // 怎么判断一层走完了
            // 这里应该有一个子循环 需要知道下一个层级到底有多少个子元素
            int size = queue.size();
            // 这里的size写死了内循环不会改变，可以直接往队列中插入元素
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                list.add(root.val);

                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            // 这样的话 下一个大循环进来 就刚好是下一层的全部元素
            res.addFirst(list);
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
