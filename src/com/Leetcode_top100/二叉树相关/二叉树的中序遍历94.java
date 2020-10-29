package com.Leetcode_top100.二叉树相关;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/24 10:57
 * # @version 1.0
 * # @File : 二叉树相关.java
 * # @Software: IntelliJ IDEA
 */
public class 二叉树的中序遍历94 {

//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inorder(list, root);
            return list;

        }

        public void inorder(List<Integer> list, TreeNode root) {
            if (root == null) return;
            inorder(list, root.left);
            list.add(root.val);
            inorder(list, root.right);

        }
    }

    class Solution2 {
        //迭代的写法
        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> list = new ArrayList<>();
            if (root == null) return list;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;

            while (!stack.empty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;

                } else {
                    node = stack.pop();
                    list.add(node.val);
                    node = node.right;
                }


            }


            return list;

        }


    }
    public class Solution3 {
        public List < Integer > inorderTraversal(TreeNode root) {
            List < Integer > res = new ArrayList < > ();
            Stack < TreeNode > stack = new Stack < > ();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
            return res;
        }
    }
    // 莫里斯中序遍历
    class Solution6 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ldr = new ArrayList<Integer>();
            TreeNode cur = root;
            TreeNode pre = null;
            while(cur!=null){
                if(cur.left==null){//左子树为空，输出当前节点，将其右孩子作为当前节点
                    ldr.add(cur.val);
                    cur = cur.right;
                }
                else{
                    pre = cur.left;//左子树
                    while(pre.right!=null&&pre.right!=cur){//找到前驱节点，即左子树中的最右节点
                        pre = pre.right;
                    }
                    //如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
                    if(pre.right==null){
                        pre.right = cur;
                        cur = cur.left;
                    }
                    //如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。
                    if(pre.right==cur){
                        pre.right = null;
                        ldr.add(cur.val);
                        cur = cur.right;
                    }
                }
            }
            return ldr;
        }
    }

}
