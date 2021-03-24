package com.LeetCode_jianzhioffer.PrintTreeNode59;

import java.util.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/13 21:03
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

        public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            //使用两个栈，一个存奇数层，一个存偶数层。因为是紧贴的，所以不用根据奇偶层来判断。
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();

            //检查参数
            if (pRoot == null) {
                return result;
            }
            ArrayList<Integer> tempList = new ArrayList<>();

            stack1.push(pRoot);
            //直到两个栈都为empty才停止
            while (!stack1.isEmpty() || !stack2.empty()) {
                while (!stack1.isEmpty()) {
                    TreeNode tempNode = stack1.pop();
                    //stack1依次出栈，然后加入到子list中，从左边往右边，
                    //第二次循环的时候，stack2往stack1存储的时候是从右往左（先右字节点，再左边子节点），出栈的时候顺序正好是从左往右
                    tempList.add(tempNode.val);
                    //往偶数层存，从左到右，
                    if (tempNode.left != null) {
                        stack2.add(tempNode.left);
                        //
                    }
                    if (tempNode.right != null) {
                        stack2.add(tempNode.right);
                    }
                }

                if (!tempList.isEmpty()) {
                    result.add(tempList);
                    tempList = new ArrayList<>();
                }
                while (!stack2.isEmpty()) {
                    //因为栈是先进后出，在stack2中是从左往右边依次存储的，出栈的顺序就是从右往左，正好反过来
                    TreeNode tempNode = stack2.pop();
                    tempList.add(tempNode.val);
                    //往奇数层存，从右到左
                    if (tempNode.right != null) {
                        stack1.add(tempNode.right);
                    }
                    if (tempNode.left != null) {
                        stack1.add(tempNode.left);
                    }
                }
                if (!tempList.isEmpty()) {
                    result.add(tempList);
                    tempList = new ArrayList<>();
                }


            }


            return result;


        }


    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
