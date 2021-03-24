package com.企业面试题;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * # @author  chilcyWind
 * # @Time   2020/10/27 20:25
 * # @version 1.0
 * # @File : nc14.java
 * # @Software: IntelliJ IDEA
 */
public class nc14 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode();
        root.right = new TreeNode();
        root.left.val = 2;
        root.right.val = 3;
        ArrayList<ArrayList<Integer>> lists = zigzagLevelOrder(root);
        for (int i = 0; i < lists.size(); i++) {
            ArrayList<Integer> list = lists.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.println(list.get(i));
            }
        }


    }

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

            }
            flag=!flag;
            res.add(list);


        }


        return res;
    }


}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode() {  }
    TreeNode(int x) { val = x; }

}