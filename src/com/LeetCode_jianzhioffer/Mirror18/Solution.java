package com.LeetCode_jianzhioffer.Mirror18;

import java.util.LinkedList;
import java.util.Queue;

/**
 * # @author  chilcyWind
 * # @Time   2020/5/26 12:11
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 *
 *操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 *
 *
 */


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public void Mirror(TreeNode root) {
        if(root!=null){
            if (root.left!=null||root.right!=null){
                TreeNode sup= root.left;
                root.left=root.right;
                root.right=sup;
            }else  return;
            Mirror(root.left);
            Mirror(root.right);
        }


    }

    public void Mirror2(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode curr, temp;
        nodes.offer(root);
        while(!nodes.isEmpty()){
            int len = nodes.size();
            for(int i = 0; i < len; i++){
                curr = nodes.poll();
                temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
                if(curr.left != null) nodes.offer(curr.left);
                if(curr.right != null) nodes.offer(curr.right);
            }
        }
    }


}