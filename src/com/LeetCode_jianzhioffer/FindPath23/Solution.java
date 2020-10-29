package com.LeetCode_jianzhioffer.FindPath23;

import java.util.ArrayList;

/**
 * # @author  chilcyWind
 * # @Time   2020/5/29 13:03
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 * <p>
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到
 * 叶结点所经过的结点形成一条路径。
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

    ArrayList<ArrayList<Integer>> result =new ArrayList<>();
    ArrayList<Integer>  list=new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        if (root ==null)return result;
        list.add(root.val);
        target=target-root.val;
        if (root.left==null&&root.right==null&&target==0){
            result.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return result;

    }


}
