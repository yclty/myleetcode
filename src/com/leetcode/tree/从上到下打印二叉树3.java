package com.leetcode.tree;

import com.leetcode.common.TreeNode;

import java.util.*;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * 例如:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *    3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class 从上到下打印二叉树3 {
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
        boolean flag = false;
        while (!queue.isEmpty()) {
            LinkedList<Integer> subList = new LinkedList<>();
            while (size-- > 0) {
                root = queue.poll();
                if (flag) {
                    subList.addFirst(root.val);
                } else {
                    subList.add(root.val);
                }

                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            flag = !flag;
            size = queue.size();
            list.add(subList);

        }
        return list;
    }

}
