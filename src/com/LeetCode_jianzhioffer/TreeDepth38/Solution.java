package com.LeetCode_jianzhioffer.TreeDepth38;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/16 23:42
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
    class TreeNode{
        int val;
        TreeNode left=null;
        TreeNode right=null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int TreeDepth(TreeNode root) {
        if (root==null) return 0;
        else return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;

    }
}
