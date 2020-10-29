package com.Leetcode_top100.动态规划;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/18 23:02
 * # @version 1.0
 * # @File : 买卖股票的最佳时机含手续费714.java
 * # @Software: IntelliJ IDEA
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 */
public class 买卖股票的最佳时机含手续费714 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
//            每次交易要支付手续费，只要把手续费从利润中减去即可。改写方程：
//            注意买入再卖出才算是完成一笔交易，才需要付费
//            dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
//            dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
//            解释：相当于买入股票的价格升高了。
//            在第一个式子里减也是一样的，相当于卖出股票的价格减小了。
           int  dp_i_k_0=0;// dp[i][0]前一天已经卖了或者没有买入 的收益
           int dp_i_k_1=Integer.MIN_VALUE;// dp[i][0]前一天买入或保持持有以后的收益
            for(int i=0;i<prices.length ;i++){
                int tem=dp_i_k_0;//在计算dp_i_k_1以前，dp_i_k_0已经被修改过了，因此要借助一个辅助遍历保存结果

                // 买入再卖出才算是完成一笔交易，才需要付费，
                // 是买入的时候付费还是卖出的时候付费，因为假设初始值前一天卖出的时候是0，并不知道是执行了卖出还是继续空窗的操作，
                // 而初始值前一天买入的价值是最小的值，可以假设已经是付了手续费的，这样就每次买入的时候扣除手续费
                dp_i_k_0=Integer.max(dp_i_k_0,dp_i_k_1+prices[i]);
                dp_i_k_1=Integer.max(tem-prices[i]-fee,dp_i_k_1);

            }
            return dp_i_k_0;


        }
    }
}
