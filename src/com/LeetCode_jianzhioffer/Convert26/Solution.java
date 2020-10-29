package com.LeetCode_jianzhioffer.Convert26;

import java.util.Stack;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/18 17:54
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

    public TreeNode Convert(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode pre=null;
        TreeNode p=root;
        boolean isFirst=true;
        while (p!=null||!stack.isEmpty()){
            while (p!=null){//寻找子树的最左节点
                stack.push(p);
                p=p.left;
            }
            p=stack.pop();
            if (isFirst){//处理第一个节点，第一个节点没有前置节点
                root=p;
                pre=root;
                isFirst=false;
            }else {pre.right=p;//相当于遍历当前节点，因为不是第一个了，修改他之前节点的指向
            p.left=pre;
            pre=p;

            }
            p=p.right;//中序遍历，遍历下一个节点

        }
        return  root;


    }

}
