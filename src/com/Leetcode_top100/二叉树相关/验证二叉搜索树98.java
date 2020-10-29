package com.Leetcode_top100.二叉树相关;

import java.util.Stack;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/24 14:54
 * # @version 1.0
 * # @File : 验证二叉搜索树98.java
 * # @Software: IntelliJ IDEA
 */
public class 验证二叉搜索树98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            return dfsLeft(root.val, root.left) & dfsRight(root.val, root.right) & isValidBST(root.left) & isValidBST(root.right);
        }

        public boolean dfsLeft(int val, TreeNode root) {
            if (root == null) {
                return true;
            }
            if (root.val >= val) {
                return false;
            }
            return dfsLeft(val, root.left) && dfsLeft(val, root.right);

        }

        public boolean dfsRight(int val, TreeNode root) {
            if (root == null) {
                return true;
            }
            if (root.val <= val) {
                return false;
            }
            return dfsRight(val, root.left) && dfsRight(val, root.right);

        }

    }

    class Solution2 {
        //bfs遍历。边遍历边更新上界和下界
        public boolean isValidBST(TreeNode root) {
            return recurse(root,null,null);

        }
        public boolean recurse(TreeNode node,Integer lower,Integer upper){
            if (node==null) return true;
            if (lower!=null&&node.val<=lower) return false;
            if (upper!=null&&node.val>=upper) return false;
            return recurse(node.left,lower,node.val)&&recurse(node.right,node.val,upper);
        }
    }
    class Solution3 {
//        二叉搜索树的中序遍历是一个递增的序列，这个可以用来判断一个树是不是二叉搜索树
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack();
            double inorder = - Double.MAX_VALUE;

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
                if (root.val <= inorder) return false;
                inorder = root.val;
                root = root.right;
            }
            return true;
        }
    }



}
