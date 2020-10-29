package com.Leetcode_top100.动态规划;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/19 0:37
 * # @version 1.0
 * # @File : 买卖股票的最佳时机IV188.java
 * # @Software: IntelliJ IDEA
 */
public class 买卖股票的最佳时机IV188 {
    //    一次交易由买入和卖出构成，至少需要两天。所以说有效的限制 k 应该不超过 n/2，
//    如果超过，就没有约束作用了，相当于 k = +infinity。这种情况是之前解决过的。题目122中的不限次数买卖
    //买入的时候
    class Solution {
        int maxProfit_k_any(int max_k, int[] prices) {
            if (max_k == 0) return 0;
            int n = prices.length;
            if (max_k > n / 2)
                return maxProfit_k_inf(prices);
            int[][][] dp = new int[n][max_k + 1][2];
            for (int i = 0; i < n; i++)
                for (int k = max_k; k >= 1; k--) {
                    if (i - 1 == -1) {//也就是第一天操作 i=0
                        dp[i][k][0] = 0;//第一天保持不买入，收益为0
                        dp[i][k][1] = 0 - prices[i];//第一天买入，收益为0-price[0];
                        continue;
                        //初始化第一行 i=0的时候
                    }
                    //i=1,也就是第二天开始操作
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                }
            return dp[n - 1][max_k][0];
        }

        //题目122中的不限次数买卖
        int maxProfit_k_inf(int[] prices) {
            int n = prices.length;
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
            }
            return dp_i_0;
        }
    }

    class Solution2 {
        public int maxProfit(int k, int[] prices) {
            if (k < 1) {
                return 0;
            }

            // k 超过了上限，也就变成了 无限次交易问题
            if (k > prices.length / 2) {
                return maxProfitOfII(prices);
            }
            // 状态定义
            int[][] dp = new int[k][2];

            // 初始化
            for (int i = 0; i < k; i++) {
                dp[i][0] = Integer.MIN_VALUE;
            }
            // 遍历每一天，模拟 k 次交易，计算并更新状态
            for (int p : prices) {

                dp[0][0] = Math.max(dp[0][0], 0 - p);                  // 第 1 次买
                dp[0][1] = Math.max(dp[0][1], dp[0][0] + p);           // 第 1 次卖

                for (int i = 1; i < k; i++) {
                    dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] - p);   // 第 i 次买
                    dp[i][1] = Math.max(dp[i][1], dp[i][0] + p);       // 第 i 次卖
                }
            }
            return dp[k - 1][1];
        }

        // 解决无限次交易的方法
        public int maxProfitOfII(int[] prices) {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    res += prices[i] - prices[i - 1];
                }
            }
            return res;
        }
    }


}

