package com.二刷leetcode核心题目.动态规划;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/15 21:25
 * # @version 1.0
 * # @File : 目标和_494.java
 * # @Software: IntelliJ IDEA
 */
//我们用 dp[i][j] 表示用数组中的前 i 个元素，组成和为 j 的方案数。
//dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]
// 也可以写成递推的形式：
//
//dp[i][j + nums[i]] += dp[i - 1][j]
//dp[i][j - nums[i]] += dp[i - 1][j]

//    由于数组中所有数的和不超过 1000，那么 j 的最小值可以达到 -1000。
//    在很多语言中，是不允许数组的下标为负数的，因此我们需要给 dp[i][j] 的第二维预先增加 1000，即：
//            dp[i][j + nums[i] + 1000] += dp[i - 1][j + 1000]
//            dp[i][j - nums[i] + 1000] += dp[i - 1][j + 1000]


public class 目标和_494 {
    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = -1000; j <= 1000; j++) {
                if (dp[i - 1][j + 1000] > 0) {
//                    如果dp[i - 1][j + 1000]=0的话，说明前i个元素构不成j，就没必要再分析从j推+ -nums[ i+1]个元素,
                    //而且两个位置赋值也是0.没必要
                    dp[i][j + nums[i] + 1000] += dp[i - 1][j + 1000];
                    dp[i][j - nums[i] + 1000] += dp[i - 1][j + 1000];
                }
            }

        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }

}
