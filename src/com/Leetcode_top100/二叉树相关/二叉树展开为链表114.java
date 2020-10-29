package com.Leetcode_top100.二叉树相关;

import org.w3c.dom.ls.LSException;
import sun.security.krb5.internal.crypto.Des;

import java.util.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/2 16:44
 * # @version 1.0
 * # @File : 二叉树展开为链表114.java
 * # @Software: IntelliJ IDEA
 * <p>
 * 前序遍历，借助一个栈
 */
public class 二叉树展开为链表114 {
    class TreeNode {
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

    //借助栈
    class Solution {
        public void flatten(TreeNode root) {
            if (root == null) return;
            Stack<TreeNode> stack = new Stack<>();
            List<TreeNode> list = new LinkedList<>();
            stack.push(root);
            TreeNode cur = root;
            while (!stack.isEmpty()) {
                cur = stack.pop();
                list.add(cur);
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);

            }
            for (int i = 1; i < list.size(); i++) {
                TreeNode prev = list.get(i - 1), curr = list.get(i);
                prev.left = null;
                prev.right = curr;
            }


        }

    }
    //递归

    class Solution2 {
        public void flatten(TreeNode root) {
            if (root == null) return;
            Deque<TreeNode> stack = new LinkedList<>();
            List<TreeNode> list = new LinkedList<>();
            preorderTraversal(list, root);
            for (int i = 1; i < list.size(); i++) {
                TreeNode prev = list.get(i - 1), curr = list.get(i);
                prev.left = null;
                prev.right = curr;
            }


        }

        public void preorderTraversal(List<TreeNode> list, TreeNode root) {
            if (root != null) {
                list.add(root);
                preorderTraversal(list, root.left);
                preorderTraversal(list, root.right);
            }
        }

    }

}
