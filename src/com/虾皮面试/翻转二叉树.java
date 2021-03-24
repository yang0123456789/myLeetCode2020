package com.虾皮面试;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/21
 * @Version 1.0
 **/
public class 翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;


    }

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            Queue<TreeNode> queue = new LinkedList<>();
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
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
