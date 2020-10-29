package com.Leetcode_top100;

import java.util.Stack;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/14 15:01
 * # @version 1.0
 * # @File : 把二叉搜索树转换为累加树538.java
 * # @Software: IntelliJ IDEA
 */
public class 把二叉搜索树转换为累加树538 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        int tem = 0;

        //先右子树，再中间，再左子树 借助一个辅助的int值记录访问的总和
        public TreeNode convertBST(TreeNode root) {
            if (root == null) return root;
            depth(root);
            return root;


        }

        public void depth(TreeNode node) {
            if (node == null) return;
            depth(node.right);
            node.val += tem;
            tem = node.val;
            depth(node.left);

        }
    }

    class Solution2 {

        int tem = 0;

        //先右子树，再中间，再左子树 借助一个辅助的int值记录访问的总和
        public TreeNode convertBST(TreeNode root) {
            Stack<TreeNode> stack=new Stack<>();
            int tem=0;
            TreeNode node=root;

            while (!stack.isEmpty()||node!=null){
                while (node!=null){
                    stack.add(node);
                    node=node.right;
                }
                node=stack.pop();
                tem+=node.val;
                node.val=tem;
                node=node.left;

            }
            return root;

        }

    }

}

