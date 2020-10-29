package com.Leetcode_top100.动态规划;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/18 18:08
 * # @version 1.0
 * # @File : 买卖股票的最佳时机2_122.java
 * # @Software: IntelliJ IDEA
 */
public class 买卖股票的最佳时机2_122 {
    class Solution {
        public int maxProfit(int[] prices) {
           int n=prices.length;
           //每一天有两种结果状态，持有1和不持有0，按结果根据昨天持有和不持有的最大收益进行计算
           int dp_i_k_1=Integer.MIN_VALUE;//初始值持有的净利润
           int dp_i_k_0=0;//初始值不持有净利润
            for(int i=0;i<prices.length ;i++){
                dp_i_k_0=Math.max(dp_i_k_0,dp_i_k_1+prices[i]);//假如第i天不持有，最大收益为1.i-1天不持有，i天继续不持有，也就是昨天的收益
                                                                // 2.i-1天持有，i天卖出以后不持有，也就是昨天持有的收益+今天卖出的收益
                dp_i_k_1=Math.max(dp_i_k_0-prices[i],dp_i_k_1);//假如第i天持有，最大收益为1.i-1天不持有，i天买入持有，也就是昨天的收益-今天的价格
                // 2.i-1天持有，i天继续持有，不进行任何操作，收益仍然是昨天的。


            }
            return dp_i_k_0;

        }
    }
}
