package com.leetcode.tree;

import com.leetcode.common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * leetcode 103. 二叉树的锯齿形层序遍历
 *
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 */
public class ZMidLevelTree {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 层序遍历的变种 第一次左到右  第二次 右到左 交替进行

        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;

        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                // 问题复杂化了 没必要在取的时候倒序 只需要拿值的时候放到list的first即可
                if (flag) {
                    list.addFirst(poll.val);
                } else {
                    list.add(poll.val);
                }
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            flag = !flag;
            res.add(list);
        }

        return res;
    }
}
