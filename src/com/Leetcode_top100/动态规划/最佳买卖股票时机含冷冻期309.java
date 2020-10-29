package com.Leetcode_top100.动态规划;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/18 14:59
 * # @version 1.0
 * # @File : 最佳买卖股票时机含冷冻期.java
 * # @Software: IntelliJ IDEA
 */
public class 最佳买卖股票时机含冷冻期309 {
    class Solution {
        public int maxProfit(int[] prices) {
            int n=prices.length;
            //每一天有两种结果状态，持有1和不持有0，按结果根据昨天持有和不持有的最大收益进行计算,加上冷静期的考虑，
            // 就是前一天如果是卖出，第二天是不能买入的，加上这个条件，每次 sell 之后要等一天才能继续交易。只要把这个特点融入上一题的状态转移方程即可：
            //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            //dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
            //解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
            int dp_i_k_1=Integer.MIN_VALUE;//初始值持有的净利润
            int dp_i_k_0=0;//初始值不持有净利润，代表i-1天的利润值
            int dp_pre_0 = 0;//代表 dp[i-2][0]，也就是前两天卖出的时候的收益，为了服务冷静期
            for(int i=0;i<prices.length ;i++){
                int temp = dp_i_k_0;//用来更新i-2天的值,
                dp_i_k_0=Math.max(dp_i_k_0,dp_i_k_1+prices[i]);//假如第i天不持有，最大收益为1.i-1天不持有，i天继续不持有，也就是昨天的收益
                // 2.i-1天持有，i天卖出以后不持有，也就是昨天持有的收益+今天卖出的收益

                dp_i_k_1=Math.max(dp_pre_0-prices[i],dp_i_k_1);
//                解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
                //假如第i天持有，最大收益为1.i-2天不持有，i天买入持有，也就是前天的收益-今天的价格
                // 2.i-1天持有，i天继续持有，不进行任何操作，收益仍然是昨天的。

                dp_pre_0=  temp;
            }
            return dp_i_k_0;
        }
    }

}
