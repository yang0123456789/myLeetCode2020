package com.Leetcode_top100.二叉树相关;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/24 16:34
 * # @version 1.0
 * # @File : 二叉树的层序遍历102.java
 * # @Software: IntelliJ IDEA
 */
public class 二叉树的层序遍历102 {
    class Solution {
        //广度优先搜索
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> q1 = new LinkedList<>();
            Queue<TreeNode> q2 = new LinkedList<>();
            if (root == null) return ans;
            q1.offer(root);
            while (!q1.isEmpty() || !q2.isEmpty()) {

                if (q1.isEmpty()) {


                    List<Integer> list = new ArrayList<>();
                    while (!q2.isEmpty()) {
                        TreeNode cur = q2.poll();
                        list.add(cur.val);
                        if (cur.left != null)
                            q1.offer(cur.left);
                        if (cur.right != null) {
                            q1.offer(cur.right);
                        }
                    }
                    ans.add(list);
                } else {
                    Queue<TreeNode> tem = q2;
                    q2 = q1;
                    q1 = tem;
                }
            }
            return ans;
        }
    }

    class Solution2 {
        //递归解法
        List<List<Integer>> levels = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return levels;
            helper(root, 0);//root是第0层
            return levels;
        }

        public void helper(TreeNode node, int level) {
            if (levels.size() == level) {
                levels.add(new ArrayList<Integer>());
                //level从0层开始，如果levels的数量和level相等，说明levels中没有level对应的层
                //例如，根节点是第0层。而levels.size 为0的话，说明它是空的
            }
            levels.get(level).add(node.val);
            if (node.left != null) {
                helper(node.left, level + 1);
            }
            if (node.right != null) {
                helper(node.right, level + 1);
            }
        }

    }
}
