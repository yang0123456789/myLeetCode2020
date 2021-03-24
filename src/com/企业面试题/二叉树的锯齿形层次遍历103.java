package com.企业面试题;

import java.util.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/17 21:19
 * # @version 1.0
 * # @File : 二叉树的锯齿形层次遍历103.java
 * # @Software: IntelliJ IDEA
 *
 */
public class 二叉树的锯齿形层次遍历103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = false;
        if (root == null) return res;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int len = 1;
        while (queue.size()!=0) {
            if (flag == false) {
                List<Integer> list = new ArrayList<>();
                while (len != 0) {
                    TreeNode tem = queue.poll();
                    list.add(tem.val);
                    len--;
                    if (tem.left != null) {
                        queue.offer(tem.left);
                    }
                    if (tem.right != null) {
                        queue.offer(tem.right);
                    }
                }
                res.add(list);
                flag = true;

            } else {
                List<Integer> list = new ArrayList<>();
                while (len != 0) {
                    TreeNode tem = queue.poll();
                    list.add(tem.val);
                    len--;
                    if (tem.left != null) {
                        queue.offer(tem.left);
                    }
                    if (tem.right != null) {
                        queue.offer(tem.right);
                    }
                }
                Collections.reverse(list);
                res.add(list);
                flag = false;
            }
            len = queue.size();
        }

        return res;
    }
}
