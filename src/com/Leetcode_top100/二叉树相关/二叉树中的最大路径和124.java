package com.Leetcode_top100.二叉树相关;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/24 21:43
 * # @version 1.0
 * # @File : 二叉树中的最大路径和124.java
 * # @Software: IntelliJ IDEA
 */
public class 二叉树中的最大路径和124 {
    class Solution {
        int maxSum = Integer.MIN_VALUE;//记录最大的路径和

        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return maxSum;
        }

        public int maxGain(TreeNode node) {
            if (node == null) {
                return 0;
            }

            // 递归计算左右子节点的最大贡献值
            // 只有在最大贡献值大于 0 时，才会选取对应子节点
            int leftGain = Math.max(maxGain(node.left), 0);
            int rightGain = Math.max(maxGain(node.right), 0);

            // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
            int priceNewpath = node.val + leftGain + rightGain;//这个值是以该节点+左+右子树构成的路径的最大和，
            // 这样计算完每个节点的这个值，然后就能遍历完所有可能的路径

            // 更新答案
            maxSum = Math.max(maxSum, priceNewpath);//递归的最外层就是包含根节点的路径的priceNewpath。递归会遍历所有可能的子树的路径以及根节点的路径

            // 返回节点的最大贡献值
            return node.val + Math.max(leftGain, rightGain);
            //返回的话，只能返回以该节点为起点，在左或者右子树为选出一条路径与根节点形成一条包含根节点的子树最长路径
        }
    }


}
