package com.企业面试题;

import java.util.ArrayList;
import java.util.List;

/**
 * # @author  chilcyWind
 * # @Time   2020/10/30 9:25
 * # @version 1.0
 * # @File : nc45.java
 * # @Software: IntelliJ IDEA
 */
public class nc45 {
    public ArrayList<Integer> pre;
    public ArrayList<Integer> in;
    public ArrayList<Integer> post;

    public int[][] threeOrders(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        preOrder(root);
        inOrder(root);
        postOrder(root);
        ans.add(pre);
        ans.add(in);
        ans.add(post);
        int[][] res = new int[ans.size()][ans.get(0).size()];
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(0).size(); j++) {
                res[i][j] = ans.get(i).get(j);
            }
        }
        return res;
    }

    public  void preOrder(TreeNode root) {


        if (root == null) return;
        pre.add(root.val);
        preOrder(root.left);
        preOrder(root.right);

    }

    public void inOrder(TreeNode root) {


        if (root == null) return;
        inOrder(root.left);
        in.add(root.val);
        inOrder(root.right);

    }

    public void postOrder(TreeNode root) {

        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        post.add(root.val);

    }


    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}
