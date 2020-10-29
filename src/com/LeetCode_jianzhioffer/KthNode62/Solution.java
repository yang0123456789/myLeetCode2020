package com.LeetCode_jianzhioffer.KthNode62;

import java.util.Stack;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/6 11:13
 * # @version 1.0
 * # @File : Solutin.java
 * # @Software: IntelliJ IDEA
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */

public class Solution {
    int index = 0;
        class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot==null||k==0) return null;
        int count=0;
        Stack<TreeNode> stack=new Stack<>();
        while (pRoot!=null||!stack.isEmpty()){
            while (pRoot!=null){
                stack.push(pRoot);
                pRoot=pRoot.left;
            }
            pRoot=stack.pop();
            count+=1;
            if (count==k){
                return pRoot;
            }
            pRoot=pRoot.right;


        }

    return null;
    }



}