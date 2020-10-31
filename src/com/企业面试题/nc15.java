package com.企业面试题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/1 0:13
 * # @version 1.0
 * # @File : nc15.java
 * # @Software: IntelliJ IDEA
 */
public class nc15 {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
//        Stack<TreeNode> stack=new Stack<>();
//        stack.isEmpty();
//        stack.empty();

        // write code here
        ArrayList<ArrayList<Integer>> res=new   ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            Queue<TreeNode> tem=new LinkedList<>();
            ArrayList<Integer> list=new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null) tem.add((node.left));
                if(node.right!=null) tem.add((node.right));
            }
            queue=tem;
            res.add(list);

        }
        return res;
    }
}
