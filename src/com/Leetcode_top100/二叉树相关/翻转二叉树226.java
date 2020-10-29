package com.Leetcode_top100.二叉树相关;


import java.util.LinkedList;
import java.util.Queue;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/4 20:56
 * # @version 1.0
 * # @File : 翻转二叉树226.java
 * # @Software: IntelliJ IDEA
 * 节点的父子关系没有发生变化，只是左右子树变了
 *
 * https://leetcode-cn.com/problems/invert-binary-tree/solution/fan-zhuan-er-cha-shu-by-leetcode/
 */
public class 翻转二叉树226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root==null) return null;
            TreeNode right=invertTree(root.right);
            TreeNode left=invertTree(root.left);
            root.left=right;
            root.right=left;
            return root;


        }
    }
}
