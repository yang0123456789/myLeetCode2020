package com.LeetCode_jianzhioffer.IsBalanced_Solution39;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/16 23:37
 * # @version 1.0
 * # @File : Solution2.java
 * # @Software: IntelliJ IDEA
 */
public class Solution2 {
    class TreeNode{
        int val;
        TreeNode left=null;
       TreeNode right=null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
       boolean isBalance=true;
    public boolean IsBalanced_Solution(TreeNode root) {
        TreeDepth1(root);
        return isBalance;
        //isBalance 会在 TreeDepth1(root)中赋值。
    }
    public int TreeDepth1(TreeNode root){
        if (root==null)return 0;
        int left=TreeDepth1(root.left);
        int right=TreeDepth1(root.right);
        if (Math.abs(left-right)>1){
            isBalance=false;
        }
        return Math.max(left,right)+1;

    }

}
