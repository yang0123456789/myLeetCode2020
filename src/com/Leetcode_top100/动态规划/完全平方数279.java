package com.Leetcode_top100.动态规划;

import java.util.HashSet;
import java.util.Set;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/5 20:36
 * # @version 1.0
 * # @File : 完全平方数279.java
 * # @Software: IntelliJ IDEA
 */
public class 完全平方数279 {
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1]; // 默认初始化值都为0
            for (int i = 1; i <= n; i++) {
                dp[i] = i; // 最坏的情况就是每次+1
                for (int j = 1; i - j * j >= 0; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
                }
            }
            return dp[n];
        }
    }
    class Solution2 {
        Set<Integer> square_nums = new HashSet<Integer>();

        protected boolean is_divided_by(int n, int count) {
            if (count == 1) {
                return square_nums.contains(n);
            }

            for (Integer square : square_nums) {
                if (is_divided_by(n - square, count - 1)) {
                    return true;
                }
            }
            return false;
        }

        public int numSquares(int n) {
            this.square_nums.clear();

            for (int i = 1; i * i <= n; ++i) {
                this.square_nums.add(i * i);
            }

            int count = 1;
            for (; count <= n; ++count) {
                if (is_divided_by(n, count))
                    return count;
            }
            return count;
        }
    }


    class Solution3 {
      public   int numSquares(int n) {
            int[] choices=new int[n+1];
            int res = 1;

            // 构造物品，即所有小于给定数字的完全平方数
            while (n / res >= res) {
                choices[res-1]=(res * res);
                res++;
            }

         int size = res;
            int[] dp=new int[n + 1];

            // init
            for (int i = 0; i <= n; ++i) {
                dp[i] = i;
            }

            // 完全背包模板
            for (int i = 1; i < size; ++i) {
                for (int j = choices[i]; j <= n; ++j) {
                    dp[j] = Math.min(dp[j], dp[j - choices[i]] + 1);
                }
            }

            return dp[n];
        }
    }

}

