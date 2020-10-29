package com.LeetCode_jianzhioffer.isSymmetrical58;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/13 22:28
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 *
 *
 *
 * /*思路：首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
 * * 左子树的右子树和右子树的左子树相同即可，采用递归
 * * 非递归也可，采用栈或队列存取各级子树根节点
 *
 *
 */

public class Solution {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot==null){
            return true;
        }
        return comRoot(pRoot.left,pRoot.right);

    }
    public boolean comRoot(TreeNode left, TreeNode right){

        if (left==null) return right==null;
        if (right==null) return  false;
        if(left.val!=right.val) return false;
        return comRoot(left.left,right.right)&&comRoot(left.right,right.left);
    }

}
