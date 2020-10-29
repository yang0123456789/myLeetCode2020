package com.Leetcode_top100.动态规划;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/26 0:01
 * # @version 1.0
 * # @File : 乘积最大子数组152.java
 * # @Software: IntelliJ IDEA
 */
public class 乘积最大子数组152 {
    class Solution {
        //超出内存限制
        public int maxProduct(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n][n];
            int max = Integer.MIN_VALUE;
//            dp[i][j] 表示[i][j]的连续的序列乘积
            for (int i = 0; i < n; i++) {
                dp[i][i] = nums[i];
                max = Math.max(dp[i][i], max);
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    dp[i][j] = dp[i][j - 1] * nums[j];//一行一行填写
                    max = Math.max(dp[i][j], max);

                }

            }
            return max;

        }
    }

    class Solution2 {
        //不超出内存限制
        public int maxProduct(int[] nums) {
            int n = nums.length;
            int dp_ij = 1;
            int max = Integer.MIN_VALUE;
//
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (i == j) {
                        dp_ij = nums[i];
                        max = Math.max(dp_ij, max);

                    } else {
                        dp_ij = dp_ij * nums[j];
                        max = Math.max(dp_ij, max);
                    }


                }

            }
            return max;

        }
    }
    class Solution3 {
        public int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE, imax = 1, imin = 1;
            for(int i=0; i<nums.length; i++){
                if(nums[i] < 0){
                    //
                    int tmp = imax;
                    imax = imin;
                    imin = tmp;
                }
                imax = Math.max(imax*nums[i], nums[i]);//肯定能保证imax是以num[i]结尾的，这样每次都保证以num[i]结尾的最优解，下次迭代就能保证以num[i+1]结尾
                imin = Math.min(imin*nums[i], nums[i]);//同时维护一个以num[i]结尾的最小值，保证num[i+1]是负数的时候也能计算最大值

                max = Math.max(max, imax);
            }
            return max;
        }
    }


}
