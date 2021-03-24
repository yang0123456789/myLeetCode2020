package com.虾皮面试;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/24
 * @Version 1.0
 **/
public class 二叉树的深度 {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    class Solution {
        public int maxDepth(TreeNode root) {
            if(root == null) return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;



        }
    }
}
