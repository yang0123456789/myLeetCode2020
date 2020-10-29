package com.Leetcode_top100.动态规划;

import java.util.Arrays;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/22 22:23
 * # @version 1.0
 * # @File : 不同路径62.java
 * # @Software: IntelliJ IDEA
 */
public class 不同路径62 {

    class Solution {
        //    超出时间限制
        //深度优先搜索路径
        int res;

        public int uniquePaths(int m, int n) {
            boolean[][] used = new boolean[m][n];
            dfs(0, 0, m, n, used);
            return res;

        }

        public void dfs(int row, int colum, int m, int n, boolean[][] used) {
            if (row == m - 1 && colum == n - 1) {
                res++;
                return;
            }

            used[row][colum] = true;
//            机器人每次只能向下或者向右移动一步。
            if (row + 1 < m && used[row + 1][colum] == false) {
                dfs(row + 1, colum, m, n, used);
            }
//            if (row - 1 >= 0 && used[row - 1][colum] == false) {
//                dfs(row - 1, colum, m, n, used);
//            }
            if (colum + 1 < n && used[row][colum + 1] == false) {
                dfs(row, colum + 1, m, n, used);
            }
//            if (colum - 1 >= 0 && used[row][colum - 1] == false) {
//                dfs(row, colum - 1, m, n, used);
//            }
            used[row][colum] = false;

        }

    }

    class Solution2 {
        //由于机器人每次只能选向右或者向下，因此只能要达到m-1,n-1的点，需要向右走m-1次，向下走n-1次，总共需要走m+n-2次，因此只需要选出那几次往右走就行
        //排列组合，c m+n m = c m+n n，

        public int uniquePaths(int m, int n) {
            //只跟第几行第几列有关，从m+n-2步中抽出m-1步
            //只能这样，其他的方法会溢出
            long ans = 1;
            for (int i = 0; i < Math.min(m - 1, n - 1); i++) {
                ans *= m + n - 2 - i;
                ans /= i + 1;
            }
            return (int) ans;


        }

    }

    //    令 dp[i][j] 是到达 i, j 最多路径
//
//    动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
//
//    注意，对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1
//
//    时间复杂度：O(m*n)O(m∗n)
//
//    空间复杂度：O(m * n)O(m∗n)
//
//    优化：因为我们每次只需要 dp[i-1][j],dp[i][j-1]
    class Solution3 {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < n; i++) dp[0][i] = 1;
            for (int i = 0; i < m; i++) dp[i][0] = 1;
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    public int uniquePaths2(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {//相当于一行一行填写
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];//更新之前的cur[j]表示 cur[i-1]cur[j],cur[j-1]表示cur[i][j-1]
            }
        }
        return cur[n - 1];
    }
}





