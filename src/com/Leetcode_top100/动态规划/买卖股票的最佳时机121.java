package com.Leetcode_top100.动态规划;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/18 15:08
 * # @version 1.0
 * # @File : 买卖股票的最佳时机121.java
 * # @Software: IntelliJ IDEA
 */
public class 买卖股票的最佳时机121 {
    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[j] - prices[i] > profit)
                        profit = prices[j] - prices[i];


                }

            }
            return profit;
        }
    }
    class Solution2 {
        public int maxProfit(int[] prices) {
//            定义两个变量，minPrice表示第i天以前的最低价格
//                          maxProfit表示第i天经过操作能获得的最大利润
            //遍历一次数组，同时更新这两个值，让price[i]-minprice的值与maxProfit比较，更新maxProfit更新maxProfit的值
            if (prices.length<=1) return 0;
            int minPrice=prices[0];//第一天开始最小的价格就是当天的价格，
            int maxProfit=0;//不操作，利润就是0；
            for(int i=1;i<prices.length ;i++){
                if (prices[i]<minPrice){
                    minPrice=prices[i];
                }else {
                    if (prices[i]-minPrice>maxProfit){
                        maxProfit=prices[i]-minPrice;
                    }
                }

            }
            return maxProfit;

        }
    }
    // k == 1
    int maxProfit_k_1(int[] prices) {
        int n = prices.length;
        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }


}
