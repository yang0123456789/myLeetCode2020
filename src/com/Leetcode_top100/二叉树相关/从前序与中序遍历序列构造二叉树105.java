package com.Leetcode_top100.二叉树相关;

import java.util.HashMap;
import java.util.Map;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/24 20:34
 * # @version 1.0
 * # @File : 从前序与中序遍历序列构造二叉树105.java
 * # @Software: IntelliJ IDEA
 */
public class 从前序与中序遍历序列构造二叉树105 {
    class Solution {
        //递归一
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int preLen = preorder.length;
            int inLen = inorder.length;
            if (preLen != inLen) return null;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inLen; i++) {
                map.put(inorder[i], i);//快速定位前序排列元素在中序排序中的序号
            }
            return buildTree(preorder, 0, preLen - 1, map, 0, inLen - 1);

        }

        //这里的范围都是闭区间
        private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                                   Map<Integer, Integer> map, int inLeft, int inRight) {

            if (preLeft > preRight || inLeft > inRight) {
                return null;
            }
            //在中序遍历中找到根节点的位置
            int rootVal = preorder[preLeft];
            TreeNode root = new TreeNode(rootVal);
            int preIndex = map.get(rootVal);//返回根节点在中序遍历的位置
            root.left = buildTree(preorder, preLeft + 1, preIndex - inLeft + preLeft, map, inLeft, preIndex - 1);
            root.right = buildTree(preorder, preIndex - inLeft + preLeft + 1, preRight, map, preIndex + 1, inRight);
            return root;
        }
    }
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution2 {
        //递归2
        private Map<Integer, Integer> indexMap;

        public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
            if (preorder_left > preorder_right) {
                return null;
            }

            // 前序遍历中的第一个节点就是根节点
            int preorder_root = preorder_left;
            // 在中序遍历中定位根节点
            int inorder_root = indexMap.get(preorder[preorder_root]);

            // 先把根节点建立出来
            TreeNode root = new TreeNode(preorder[preorder_root]);
            // 得到左子树中的节点数目
            int size_left_subtree = inorder_root - inorder_left;
            // 递归地构造左子树，并连接到根节点
            // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
            root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
            // 递归地构造右子树，并连接到根节点
            // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
            root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
            return root;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            // 构造哈希映射，帮助我们快速定位根节点
            indexMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }
            return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
        }
    }


}
