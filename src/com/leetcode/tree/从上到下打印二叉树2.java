package com.leetcode.tree;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * 例如:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *    3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *  [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class 从上到下打印二叉树2 {
    /**
     * 标准的层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();

        // 需要有个变量记录每一层的数量
        int size = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> subList = new ArrayList<>();
            while (size-- > 0) {
                root = queue.poll();
                subList.add(root.val);

                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            size = queue.size();
            list.add(subList);

        }
        return list;
    }

}
