package com.Leetcode_top100.二叉树相关;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/14 10:43
 * # @version 1.0
 * # @File : 二叉树的直径543.java
 * # @Software: IntelliJ IDEA
 */
public class 二叉树的直径543 {
       class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
     //递归法，递归计算左子树直径+右子树直径
//    若是空，返回0，若有一个节点，返回1，然后返回左子树和右子树最大的值，
     class Solution {
         int ans;
         public int diameterOfBinaryTree(TreeNode root) {
             ans = 1;
             depth(root);
             return ans - 1;
         }
         public int depth(TreeNode node) {
             if (node == null) return 0; // 访问到空节点了，返回0
             int L = depth(node.left); // 左儿子为根的子树的深度
             int R = depth(node.right); // 右儿子为根的子树的深度
             ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
             return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
         }
     }
    class Solution2 {
        int ans;
        public int diameterOfBinaryTree(TreeNode root) {
            ans = 1;
            depth(root);
            return ans - 1;
        }
        public int depth(TreeNode node) {
           if (node==null)return 0;
           int l=depth(node.left);
           int r=depth(node.right);
           ans=Math.max(l+r+1,ans);
           return Math.max(l,r)+1;
        }
    }

}
