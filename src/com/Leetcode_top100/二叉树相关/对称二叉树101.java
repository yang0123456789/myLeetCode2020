package com.Leetcode_top100.二叉树相关;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/24 15:51
 * # @version 1.0
 * # @File : 对称二叉树101.java
 * # @Software: IntelliJ IDEA
 */
public class 对称二叉树101 {
    class Solution {
        //同步递归方法
        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }

        public boolean check(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
        }
    }
    class Solution2 {
//        「方法一」中我们用递归的方法实现了对称性的判断，那么如何用迭代的方法实现呢？首先我们引入一个队列，
//        这是把递归程序改写成迭代程序的常用方法。初始化时我们把根节点入队两次。
//        每次提取两个结点并比较它们的值（队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像），
//        然后将两个结点的左右子结点按相反的顺序插入队列中。
//        当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。


        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }

        public boolean check(TreeNode u, TreeNode v) {
            Queue<TreeNode> q = new LinkedList<TreeNode>();

            q.offer(u);
            q.offer(v);
            while (!q.isEmpty()) {
                u = q.poll();
                v = q.poll();
                if (u == null && v == null) {
                    continue;
                }
                if ((u == null || v == null) || (u.val != v.val)) {
                    return false;
                }

                q.offer(u.left);
                q.offer(v.right);

                q.offer(u.right);
                q.offer(v.left);
            }
            return true;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        //按层遍历即可
        //1.
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        //2.
        List<TreeNode> nodes = new ArrayList<>();//辅助的队列，保存层次遍历的结果
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();//size代表该层有几个节点，
            List<Integer> list = new ArrayList<>();//保存每一层的节点的值
            for (int i = 0; i < size; i++) {
                TreeNode remove = nodes.remove(0);//将上一层的节点依次出队列，然后将他们的子节点加入到队列中，这样遍历完以后里面就剩下一层的节点了
                list.add(remove.val);
                if (remove.left != null) {
                    nodes.add(remove.left);
                }
                if (remove.right != null) {
                    nodes.add(remove.right);
                }
            }
            lists.add(list);//然后将该层遍历的结果加入到结果集中
        }
        return lists;
    }
}
