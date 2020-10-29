package com.LeetCode_jianzhioffer.IsBalanced_Solution39;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/16 17:31
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

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null)
            return true;
//如果树为 null 返回 TRUE。否则判断根的左右子树的高度差的绝对值是否大于1，若大于1 则返回false。
// 否则判断树的左右孩子是否是平衡二叉树，当两者都是平衡二叉树时返回TRUE，否则返回false.
        else if(Math.abs(TreeDepth(root.left)-TreeDepth(root.right))>1)
            return false;
        else return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);

    }
    //求树的深度。
    public int TreeDepth(TreeNode root)
    {
        if(root==null)
            return 0;
        //如果树为 null 返回0 否则返回左右孩子的最大值+1。
        return Math.max(TreeDepth(root.left), TreeDepth(root.right))+1;

    }
}
