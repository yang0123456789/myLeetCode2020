package com.虾皮面试;

import java.util.*;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/20
 * @Version 1.0
 **/
public class 二叉树中序遍历 {
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

    private LinkedList<Integer> lists = new LinkedList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return lists;
        inorderTraversal(root.left);
        lists.add(root.val);
        inorderTraversal(root.right);
        return lists;

    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;


    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        if (root == null) return lists;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            lists.add(root.val);
            root=root.right;
        }
        return lists;
    }
}