package com.leetcode.tree;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 例如:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *    3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *  [3,9,20,15,7]
 */
public class 从上到下打印二叉树 {
    /**
     * 标准的层序遍历
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{};
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            list.add(root.val);
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }

        }
        return list.stream().mapToInt(x -> x).toArray();
    }

}
