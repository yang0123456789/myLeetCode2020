package com.LeetCode_jianzhioffer.PrintTreeNode60;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/13 11:05
 * # @version 1.0
 * # @File : Solution2.java
 * # @Software: IntelliJ IDEA
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 队列LinkedList完成层序遍历，用end记录每层结点数目
 */
public class Solution2 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }




    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return result;
        }
        Queue<TreeNode> layer = new LinkedList<TreeNode>();
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        layer.add(pRoot);
        int start = 0, end = 1;
        while(!layer.isEmpty()){
            TreeNode cur = layer.remove();
            layerList.add(cur.val);
            start++;
            if(cur.left!=null){
                layer.add(cur.left);
            }
            if(cur.right!=null){
                layer.add(cur.right);
            }
            if(start == end){
                end = layer.size();
                start = 0;
                result.add(layerList);
                layerList = new ArrayList<Integer>();
            }
        }
        return result;
    }
}