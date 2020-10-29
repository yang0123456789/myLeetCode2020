package com.Leetcode_top100.动态规划;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/24 14:33
 * # @version 1.0
 * # @File : 不同的二叉搜索树96.java
 * # @Software: IntelliJ IDEA
 */
public class 不同的二叉搜索树96 {
    //方法一：动态规划
//    题目要求是计算不同二叉搜索树的个数。为此，我们可以定义两个函数：
//
//    G(n): 长度为 n 的序列能构成的不同二叉搜索树的个数。
//
//    F(i, n): 以 i 为根、序列长度为 n 的不同二叉搜索树个数 (1≤i≤n)。
//
//    链接：https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/

//    举例而言，创建以 33 为根、长度为 77 的不同二叉搜索树，整个序列是 [1, 2, 3, 4, 5, 6, 7][1,2,3,4,5,6,7]，
//    我们需要从左子序列 [1, 2][1,2] 构建左子树，从右子序列 [4, 5, 6, 7][4,5,6,7] 构建右子树，然后将它们组合（即笛卡尔积）。
//对于这个例子，不同二叉搜索树的个数为 F(3, 7)F。我们将 [1,2] 构建不同左子树的数量表示为 G(2), 从 [4, 5, 6, 7] 构建不同右
// 子树的数量表示为 G(4)G(4)，注意到 G(n)G(n) 和序列的内容无关，只和序列的长度有关。于是，F(3,7)=G(2)⋅G(4)。 因此，我们可以得到以下公式：
//F(i,n)=G(i−1)⋅G(n−i)
//    对于边界情况，当序列长度为 11（只有根）或为 00（空树）时，只有一种情况，即：
//    G(0)=1,G(1)=1

    class Solution {
        public int numTrees(int n) {
            int[] g = new int[n + 1];
            g[0] = 1;
            g[1] = 1;
            for (int i = 2; i <= n; i++) {// G(i): 长度为 i 的序列能构成的不同二叉搜索树的个数。
                for (int j = 1; j <= i; j++) {//j表示由1到i节点分别作为二叉搜索树的根有几种方案
                    g[i] += g[j - 1] * g[i - j];

                }
            }
            return g[n];

        }
    }

    class Solution2 {
//        事实上我们在方法一中推导出的 G(n)函数的值在数学上被称为卡塔兰数
        public int numTrees(int n) {
            // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
            long C = 1;
            for (int i = 0; i < n; ++i) {
                C = C * 2 * (2 * i + 1) / (i + 2);
            }
            return (int) C;
        }
    }


}