package com.Leetcode_top100.动态规划;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/23 0:29
 * # @version 1.0
 * # @File : 爬楼梯70.java
 * # @Software: IntelliJ IDEA
 */
public class 爬楼梯70 {
    class Solution {
        public int climbStairs(int n) {
            if (n <= 1) return n;
//            每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

            int[] dp = new int[n + 1];
            dp[0] = 1;//假设只有一种
            dp[1] = 1;//到第一个位置只有一种方法
            for (int i = 2; i <= n; i++) {

                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];


        }
    }
    public int climbStairs2(int n) {
        if (n <= 1) return n;
//            每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？


        int cur1 = 1;//假设只有一种
        int cur2 = 1;//到第一个位置只有一种方法
        int res=0;
        for (int i = 2; i <= n; i++) {


           res=cur1+cur2;
           cur1=cur2;
           cur2=res;
        }
        return res;


    }
    //矩阵方法
    public class Solution3 {
        public int climbStairs(int n) {
            int[][] q = {{1, 1}, {1, 0}};
            int[][] res = pow(q, n);
            return res[0][0];
        }
        public int[][] pow(int[][] a, int n) {
            int[][] ret = {{1, 0}, {0, 1}};
            while (n > 0) {
                if ((n & 1) == 1) {
                    ret = multiply(ret, a);
                }
                n >>= 1;
                a = multiply(a, a);
            }
            return ret;
        }
        public int[][] multiply(int[][] a, int[][] b) {
            int[][] c = new int[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
                }
            }
            return c;
        }
    }

}


