package com.LeetCode_jianzhioffer.PrintFromTopToBottom21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * # @author  chilcyWind
 * # @Time   2020/5/29 10:42
 * # @version 1.0
 * # @File : Sulotion.java
 * # @Software: IntelliJ IDEA
 * <p>
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
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

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>() ;
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        return list;
    }
}