package com.leetcode.tree;

import com.leetcode.common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *      3
 *  9       20
 *      15      7
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 */
public class 重建二叉树 {
    private Map<Integer, Integer> rootIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 前序 ： 根左右   中序 ： 左根右
        // 把握一点  除了叶子节点  其实每个节点都是root节点，而前序的第一个节点就是root节点
        // 当构建root.left时
        // 通过前序节点的第一个节点 找到对应inorder的根节点，然后根节点的左右  就各是左子树和右子树的list
        // 由于二叉树里的节点值不重复，这里可以使用hashMap存储
        for (int i = 0; i < inorder.length; i++) {
            rootIndexMap.put(inorder[i], i);
        }

        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1 );
    }

    // 递归构建二叉树
    TreeNode dfs(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // 递归终止条件
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // 如果 preStart == preEnd  说明这个节点没有子节点了

        TreeNode root = new TreeNode(preorder[preStart]);
        Integer rootIndex = rootIndexMap.get(preorder[preStart]);
        int leftCount = rootIndex - inStart;

        // 下一个左节点的root 在 pre中的序号 以及左节点的范围 来自inorder中计算出的
        root.left = dfs(preorder, preStart + 1, preStart + leftCount,
                inorder, inStart, rootIndex - 1);

        root.right = dfs(preorder, preStart + leftCount + 1, preEnd,
                inorder, rootIndex + 1, inEnd);

        return root;
    }


}
