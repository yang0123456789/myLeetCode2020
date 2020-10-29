package com.Leetcode_top100.二叉树相关;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/24 17:17
 * # @version 1.0
 * # @File : 二叉树的最大深度104.java
 * # @Software: IntelliJ IDEA
 */
public class 二叉树的最大深度104 {
    class Solution {
        //层次遍历
        public int maxDepth(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            int depth = 0;
            if (root == null) return depth;
            TreeNode dummy = new TreeNode(Integer.MIN_VALUE);//辅助结束符
            queue.offer(root);
            queue.offer(dummy);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (cur == dummy) {
                    depth++;
                    if (!queue.isEmpty())//这个判断很重要，防止死循环，如果队列为空，说明已经遍历完了，不需要加结束符了
                    queue.offer(dummy);
                } else {
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }

            }
            return depth;
        }
    }
    class Solution3 {
        //用size帮助记忆层数的广度优先搜索
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            int ans = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    size--;
                }
                ans++;
            }
            return ans;
        }
    }


    class Solution2 {
        //递归
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int leftHeight = maxDepth(root.left);
                int rightHeight = maxDepth(root.right);
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }
    }

}
