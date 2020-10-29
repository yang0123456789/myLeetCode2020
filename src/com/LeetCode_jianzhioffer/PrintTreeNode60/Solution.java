package com.LeetCode_jianzhioffer.PrintTreeNode60;

import java.util.ArrayList;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/13 10:14
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
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
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot,1,list);

        return list;

    }
    public void depth(TreeNode root,int depth,ArrayList<ArrayList<Integer>> list){
        if (root==null)return;
        if (depth>list.size()){
            list.add(new ArrayList<Integer>());
        }
        list.get(depth-1).add(root.val);
        depth(root.left,depth+1,list);
        depth(root.right,depth+1,list);
    }
}
