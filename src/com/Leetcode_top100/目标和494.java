package com.Leetcode_top100;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/14 15:34
 * # @version 1.0
 * # @File : 目标和494.java
 * # @Software: IntelliJ IDEA
 *
 * int ：4个字节 32位
 *
 */
public class 目标和494 {
    class Solution {
        //先用暴力法试一下 每个数字有两种状态，组合起来看能不能是s di
        int count=0;
        public int findTargetSumWays(int[] nums, int S) {
            int total=0;
            sum(nums,S,0,0);
            return count;



        }
        public void sum(int[] nums,int S,int n,int total){
            if (n==nums.length){
                if (total==S)
                ++count;
                return;
            }
            sum(nums,S,n+1,total-nums[n]);
            sum(nums,S,n+1,total+nums[n]);

        }


    }
    public class Solution2 {
//        我们用 dp[i][j] 表示用数组中的前 i 个元素，组成和为 j 的方案数。
        public int findTargetSumWays(int[] nums, int S) {
            int[][] dp = new int[nums.length][2001];//-1000,1000，加上0 共2001个
            dp[0][nums[0] + 1000] = 1;//初试条件，第一行组合成nums[i]的元素，为1，只有1种方案是nums[0]的符号为+，
            dp[0][-nums[0] + 1000] += 1;//初试条件，第一行组合成-nums[i]的元素，为1，只有1种，就是nums[0]的符号为-，然后第一行其余位置都是0中方案
            for (int i = 1; i < nums.length; i++) {//一行一行遍历，根据上一行确定下一行
                for (int sum = -1000; sum <= 1000; sum++) {
                    if (dp[i - 1][sum + 1000] > 0) {//nums[sum]符号为+和为-的两种情况，都加在
                        dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];//根据上一行确定下一行
                        dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];//根据上一行确定下一行
                    }
                }
            }
            return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];//返回最终的一个值，也就是二维数组的最后一个值。
        }
    }


}
