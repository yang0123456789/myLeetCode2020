package com.Leetcode_top100.回溯算法;

import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/17 16:42
 * # @version 1.0
 * # @File : 打家劫舍iii_337.java
 * # @Software: IntelliJ IDEA
 * <p>
 * w我的思路，设置一个flag位置，然后设置一个max的全局变量，记录最大的值，
 */
public class 打家劫舍iii_337 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        //超时
        public int rob(TreeNode root) {
            int count1 = dfs(root, true);
            int cout2 = dfs(root, false);
            return cout2 > count1 ? cout2 : count1;


        }

        int dfs(TreeNode root, boolean flag) {
            if (root == null) return 0;
            if (flag == true) {
                return root.val + dfs(root.left, false) + dfs(root.right, false);

            } else {
                int res1 = dfs(root.left, true) + dfs(root.right, true);
                int res2 = dfs(root.left, false) + dfs(root.right, true);
                int res3 = dfs(root.left, false) + dfs(root.right, false);
                int res4 = dfs(root.left, true) + dfs(root.right, false);
                return Math.max(Math.max(res1, res2), Math.max(res3, res4));
            }
        }
    }

    class Solution2 {
        //爷爷 + 儿子 +孙子 三层分析，而不是像上一个两层分析。
//        投的钱选 爷爷+4个孙子，和 两个儿子中最大的方案，
//        4 个孙子投的钱加上爷爷的钱如下
//        int method1 = root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right)
//        两个儿子偷的钱如下
//        int method2 = rob(root.left) + rob(root.right);
//        挑选一个钱数多的方案则
//        int result = Math.max(method1, method2);
        HashMap<TreeNode, Integer> memo = new HashMap<>();

        public int rob(TreeNode root) {
            if (root == null) return 0;
            int money = root.val;
            if (root.left != null) {
                money += rob(root.left.left) + rob(root.left.right);//爷爷的钱加上左边的孙子
            }
            if (root.right != null) {
                money += rob(root.right.left) + rob(root.right.right);//爷爷的钱加上右儿子的孙子
            }
            int method2 = rob(root.left) + rob(root.right);//两个儿子的钱
            return Math.max(method2, money);

        }
    }

    class Solution3 {
        //爷爷 + 儿子 +孙子 三层分析，而不是像上一个两层分析。
//        投的钱选 爷爷+4个孙子，和 两个儿子中最大的方案，
//        4 个孙子投的钱加上爷爷的钱如下
//        int method1 = root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right)
//        两个儿子偷的钱如下
//        int method2 = rob(root.left) + rob(root.right);
//        挑选一个钱数多的方案则
//        int result = Math.max(method1, method2);
        public int rob(TreeNode root) {
            HashMap<TreeNode, Integer> memo = new HashMap<>();
            return dfs(root, memo);
        }

        public int dfs(TreeNode root, Map<TreeNode, Integer> memo) {
            if (root == null) return 0;
            int money = root.val;
            if (memo.containsKey(root)) return memo.get(root);
            if (root.left != null) {
                money += dfs(root.left.left, memo) + dfs(root.left.right, memo);//爷爷的钱加上左边的孙子
            }
            if (root.right != null) {
                money += dfs(root.right.left, memo) + dfs(root.right.right, memo);//爷爷的钱加上右儿子的孙子
            }
            int method2 = dfs(root.left, memo) + dfs(root.right, memo);//两个儿子的钱
            int res = Math.max(method2, money);
            memo.put(root, res);
            return res;

        }
    }

    //    动态规划
//    我们使用一个大小为 2 的数组来表示 int[] res = new int[2] 0 代表不偷，1 代表偷
//任何一个节点能偷到的最大钱的状态可以定义为
//
//当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
//当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
//root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) + Math.max(rob(root.right)[0], rob(root.right)[1])
//root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
//
    class solution4 {
        public int rob(TreeNode root) {
            int[] res = dp(root);
            return Math.max(res[0], res[1]);
        }

        public int[] dp(TreeNode root) {
            if (root == null) return new int[2];
            int res[] = new int[2];
            int[] left = dp(root.left);//返回选和不选左边孩子的数组
            int[] right = dp(root.right);//返回选和不选右边孩子的数组

            res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);//1代表选，0代表不选 ，父节点不选，子节点可以选或者不选
            res[1] = left[0]+right[0]+root.val;
            return res;

        }
    }

}
