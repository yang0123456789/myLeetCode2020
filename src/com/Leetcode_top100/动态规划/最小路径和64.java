package com.Leetcode_top100.动态规划;

import java.util.Arrays;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/22 23:39
 * # @version 1.0
 * # @File : 最小路径和64.java
 * # @Software: IntelliJ IDEA
 * <p>
 * <p>
 * //    令 dp[i][j] 是到达 i, j 最小的值
 * <p>
 * //
 * //    动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * //
 * //    注意，对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1
 * //
 * //    时间复杂度：O(m*n)O(m∗n)
 * //
 * //    空间复杂度：O(m * n)O(m∗n)
 * //
 * //    优化：因为我们每次只需要 dp[i-1][j],dp[i][j-1]中的较小的值作为前面的路径
 */
public class 最小路径和64 {
    class Solution {
        //    超出时间限制
        //深度优先搜索路径
        int res = Integer.MAX_VALUE;

        public int minPathSum(int[][] grid) {
            int m = grid.length - 1;
            int n = grid[0].length - 1;

            dfs(grid, 0, 0, m, n, 0);
            return res;

        }

        public void dfs(int[][] grid, int row, int colum, int m, int n, int total) {
            if (row == m && colum == n) {

                res = Math.min(res, total + grid[row][colum]);
                return;
            }


//            机器人每次只能向下或者向右移动一步。
            if (row + 1 <= m) {
                dfs(grid, row + 1, colum, m, n, total + grid[row][colum]);
            }

            if (colum + 1 <= n) {
                dfs(grid, row, colum + 1, m, n, total + grid[row][colum]);
            }
//

        }

    }

    class Solution2 {
        //动态规划
        //规定只能往右或者往下
//        动态方程：dp[i][j] = min{dp[i-1][j] + dp[i][j-1]}+grid[i][j]
        public int minPathSum(int[][] grid) {
            int m = grid.length ;
            int n = grid[0].length ;
            int[][] dp = new int[m][n];
            dp[0][0] =grid[0][0];
            for (int i = 1; i < n; i++) dp[0][i] = dp[0][i-1]+grid[0][i];
            for (int i = 1; i < m; i++) dp[i][0] = dp[i-1][0]+grid[i][0];

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j] ,dp[i][j - 1])+grid[i][j];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
//    路径上每个数都只用一次，直接在原数组上操作就行了

    class Solution3 {
        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            for (int i = 1; i < m; i++) {
                grid[i][0] += grid[i - 1][0];
            }
            for (int i = 1; i < n; i++) {
                grid[0][i] += grid[0][i - 1];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
            return grid[m - 1][n - 1];
        }
    }


}
