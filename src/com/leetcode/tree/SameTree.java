package com.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 */
public class SameTree {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        boolean load = isSameTree(p, q);


    }

    /*    *//**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         rightthis.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // 二叉树的层序遍历
        // 双端队列 D是double的意思，提供了两端入队 出队的方法
        Deque<TreeNode> quene = new LinkedList<TreeNode>();

        quene.offerLast(p);
        quene.offerLast(q);

        while (!quene.isEmpty()) {
            TreeNode node = quene.pollFirst();
            TreeNode node2 = quene.pollFirst();
            if (node == null && node2 == null) continue;

            if (node == null || node2 == null) return false;
            //if (node2 == null && node != null) return false;
            if (node.val != node2.val) {
                return false;
            }
            // 入队，此时如果非二叉树 则使用遍历子节点的方式
            quene.offerLast(node.left);
            quene.offerLast(node2.left);

            quene.offerLast(node.right);
            quene.offerLast(node2.right);


        }


        return true;
    }

    public static class TreeNode {
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
}
