package com.Leetcode_top100.动态规划;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/18 22:56
 * # @version 1.0
 * # @File : 买卖股票的最佳时机III123.java
 * # @Software: IntelliJ IDEA
 */
public class 买卖股票的最佳时机III123 {
    //    设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
//    原始的动态转移方程，没有可化简的地方,这里是每一次买入，增加一次k的值，算
//    dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
//    dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
    //需要创建一个三维数组，dp=new int[i][k + 1][2] 表示第i天 最多第几次买入卖出股票以后，持有1或者不持有0的钱数利润的最优值
//    而且我们可以用自然语言描述出每一个状态的含义，
//    比如说 dp[3][2][1] 的含义就是：今天是第三天，我现在手上持有着股票，至今最多进行 2 次交易。
//    再比如 dp[2][3][0] 的含义：今天是第二天，我现在手上没有持有股票，至今最多进行 3 次交易。很容易理解，对吧？
//我们想求的最终答案是 dp[n - 1][K][0]，即最后一天，最多允许 K 次交易，最多获得多少利润。


//            dp[-1][k][0] = 0;
////            解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
//            dp[-1][k][1] = Integer.MIN_VALUE;
////            解释：还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
//            dp[i][0][0] = 0;
////            解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0 。
//            dp[i][0][1] = Integer.MIN_VALUE;
////            解释：不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。

        // 假设每次买入的时候增加一次k的值，因为他的值是最小的，
//         买入的时候增加k值：dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);第一天这个值肯定是0，而不是 dp[i-1][k][1] + prices[i])，因为dp[i-1][k][1]的初试值是最小的负数，符合逻辑
//                            dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);第一天这个值肯定是dp[-1][k-1][0] - prices[i]的一个只有成本的负数，而不是dp[-1][k][1]这个最小的值
//         卖出的时候增加k值：dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k-1][1] + prices[i]);第一天这个值肯定是0，而不是 dp[i-1][k][1] + prices[i])，因为dp[i-1][k][1]的初试值是最小的负数，符合逻辑
//        //                  dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i]);


//            这道题由于没有消掉 k 的影响，所以必须要对 k 进行穷举：
//            int max_k = 2;
//            int[][][] dp = new int[n][max_k + 1][2];
//            for (int i = 0; i < n; i++) {
//                for (int k = max_k; k >= 1; k--) {
//                    if (i - 1 == -1) { /*处理 base case */ }
//                    dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
//                    dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
//                }
//            }
//// 穷举了 n × max_k × 2 个状态，正确。
//            return dp[n - 1][max_k][0];

//            相当于一行一行填写，日期是列，
//
//            这里 k 取值范围比较小，所以可以不用 for 循环，直接把 k = 1 和 2 的情况全部列举出来也可以：
//            dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
//            dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
//            dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
//            dp[i][1][1] = max(dp[i-1][1][1], -prices[i])
//
//            int maxProfit_k_2(int[] prices) {
//                int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
//                int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
//                for (int price : prices) {
//                    dp_i20 = Math.max(dp_i20, dp_i21 + price);
//                    dp_i21 = Math.max(dp_i21, dp_i10 - price);
//                    dp_i10 = Math.max(dp_i10, dp_i11 + price);
//                    dp_i11 = Math.max(dp_i11, -price);
//                }
//                return dp_i20;
//            }
class Solution {
        public int maxProfit(int[] prices) {
            int k = 2;
//        int[][][] dp=new int[prices.length+1][k + 1][2];
            int dp_i_0_0=0;//表示-1天，操作了0次，利润为0，因为是买入的时候增加k值，所以这里的k是0
            int dp_i_1_0 = 0;//只进行一次买卖的，i-1天不持有股票的初试值，
            int dp_i_1_1 = Integer.MIN_VALUE;//只进行一次买卖的，i-1天操作了一次，持有股票的初试值，
            int dp_i_2_0 = 0;//只进行两次次买卖的，i-1天操作了1次，不持有股票的初试值，
            int dp_i_2_1 = Integer.MIN_VALUE;//只进行两次次买卖的，i-1天已经操作了2次以后持有股票的初试值，
//            买入的时候增加k值：是这个公式，之所以选择

            for (int i = 0; i < prices.length; i++) {
                //先更新前一天的，再更新
                dp_i_2_0=Math.max(dp_i_2_0,dp_i_2_1+prices[i]);//前一天不持有，或者前一天持有今天卖了
                dp_i_2_1=Math.max(dp_i_2_1,dp_i_1_0-prices[i]);//前一天不持有，或者前一天持有今天卖了
                dp_i_1_0=Math.max(dp_i_1_0,dp_i_1_1+prices[i]);//前一天不持有，或者前一天持有今天卖了
                dp_i_1_1=Math.max(dp_i_1_1,dp_i_0_0-prices[i]);//前一天不持有，或者前一天持有今天卖了,dp_i_0_0表示前一天没操作过

            }
            return dp_i_2_0;

        }
    }
}
