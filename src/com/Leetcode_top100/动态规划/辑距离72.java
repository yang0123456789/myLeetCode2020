package com.Leetcode_top100.动态规划;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/23 10:14
 * # @version 1.0
 * # @File : 辑距离72.java
 * # @Software: IntelliJ IDEA
 */
public class 辑距离72 {
    class Solution {
        public int minDistance(String word1, String word2) {
            int n = word1.length();
            int m = word2.length();

            // 有一个字符串为空串
            if (n * m == 0)
                return n + m;

            // DP 数组
            int [][] D = new int[n + 1][m + 1];//我们用 `D[i][j]` 表示 `A` 的前 `i` 个字母和 `B` 的前 `j` 个字母之间的编辑距离。

            // 边界状态初始化
            for (int i = 0; i < n + 1; i++) {
                D[i][0] = i;
            }
            for (int j = 0; j < m + 1; j++) {
                D[0][j] = j;
            }

            // 计算所有 DP 值
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    int left = D[i - 1][j] + 1;//删除 i 位置的字符串以后保持 word1 前 i 个 和 word2前j个相同需要的操作
                    int down = D[i][j - 1] + 1;//在word1后面增加一个和 word[j]相同的字符以后，word1 前 i 个 和 word2前j个相同需要的操作
                    int left_down = D[i - 1][j - 1];//修改 word[i] 为word[j]
//                    D[i-1][j-1] 为 A 前 i - 1 个字符和 B 的前 j - 1 个字符编辑距离的子问题。
//                    即对于 B 的第 j 个字符，我们修改 A 的第 i 个字符使它们相同，那么 D[i][j] 最小可以为 D[i-1][j-1] + 1。
//                    特别地，如果 A 的第 i 个字符和 B 的第 j 个字符原本就相同，那么我们实际上不需要进行修改操作。在这种情况下，
//                    D[i][j] 最小可以为 D[i-1][j-1]。
                    if (word1.charAt(i - 1) != word2.charAt(j - 1))
                        left_down += 1;//修改的时候，
                    D[i][j] = Math.min(left, Math.min(down, left_down));

                }
            }
            return D[n][m];
        }
    }



}
