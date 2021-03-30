package com.虾皮;



/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/26
 * @Version 1.0
 **/
public class 二叉搜索树的第k大节点 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int res,k;
        public int kthLargest(TreeNode root, int k) {
            this.k=k;
            dfs(root);
            return res;

        }
        void dfs(TreeNode root){
            if(root==null) return;
            dfs(root.right);
            if(k==0) return;
            if(--k == 0) res = root.val;

            dfs(root.left);
        }
    }
}
