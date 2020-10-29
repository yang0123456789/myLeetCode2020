package com.Leetcode_top100.动态规划;

import java.util.Arrays;
import java.util.logging.Level;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/19 22:08
 * # @version 1.0
 * # @File : wefsdf.java
 * # @Software: IntelliJ IDEA
 */
public class 戳气球312 {
    class Solution {
        public int[][] rec;
        public int[] val;

        public int maxCoins(int[] nums) {
            int n = nums.length;
            val = new int[n + 2];
            for (int i = 1; i <= n; i++) {
                val[i] = nums[i - 1];
            }
            val[0] = val[n + 1] = 1;
            rec = new int[n + 2][n + 2];
            for (int i = 0; i <= n + 1; i++) {
                Arrays.fill(rec[i], -1);
            }
            return solve(0, n + 1);
        }

        public int solve(int left, int right) {
            if (left >= right - 1) {
                return 0;
            }
            if (rec[left][right] != -1) {
                return rec[left][right];
            }
            for (int i = left + 1; i < right; i++) {
                int sum = val[left] * val[i] * val[right];
                sum += solve(left, i) + solve(i, right);
                rec[left][right] = Math.max(rec[left][right], sum);
            }
            return rec[left][right];
        }
    }

    /**
     * @Author Nyr
     * @Date 2019/11/30 0:23
     * @Param nums:气球数组；length:数组长度，避免每层都计算一次；begin:开始下标；end:结束下标；cache:缓存，避免重复计算
     * @Return
     * @Exception
     * @Description 状态转移方程 def( i, j ) = max { def( i , k ) + def( k , j )+nums[ i ][ j ][ k ] } | i<k<j 的实现
     */
    class Solution2 {


        public int maxCoins(int[] nums, int length, int begin, int end, int[][] cache) {
            //回归条件，问题分解到最小子问题
            if (begin == end - 1) {//左右区间相邻，就返回
                return 0;
            }
            //缓存，避免重复计算
            if (cache[begin][end] != 0) {
                return cache[begin][end];
            }
            //维护一个最大值
            int max = 0;
            //状态转移方程 def( i, j ) = max { def( i , k ) + def( k , j )+nums[ i ][ j ][ k ] } | i<k<j
            for (int i = begin + 1; i < end; i++) {
                int temp = maxCoins(nums, length, begin, i, cache) +
                        maxCoins(nums, length, i, end, cache) + nums[begin] * nums[i] * nums[end];
                if (temp > max) {
                    max = temp;
                }
            }
            //缓存，避免重复计算
            cache[begin][end] = max;
            return max;
        }

    }


    class Solution5 {
        int maxCoin = 0;
        int[][] cache;//缓存，避免重复计算
//        举个例子，对于区间 0 到 4 之间的结果，递归过程是：
//  　dp[0][4] =max { dp[0][1]+dp[1][4]+nums[0]*nums[1]*nums[4]
//                  , dp[0][2]+dp[2][4]+nums[0]*nums[2]*nums[4] ,
//                  dp[0][3]+dp[3][4]+nums[0]*nums[3]*nums[4] }
        public int maxCoins(int[] nums) {
            //空数组处理
            if (nums == null) {
                return maxCoin;
            }
            //加虚拟边界
            int length = nums.length;
            int[] nums2 = new int[length + 2];
            System.arraycopy(nums, 0, nums2, 1, length);
            nums2[0] = 1;
            nums2[length + 1] = 1;
            length = nums2.length;
            //创建缓存数组
            int[][] cache = new int[length][length];
            //调用分治函数
            return maxCoins4M(nums2, length, cache);
        }

        public int maxCoins4M(int[] nums, int length, int[][] cache) {
            int max = maxCoins4(nums, length, 0, length - 1, cache);
            return max;
        }
        public  int maxCoins4(int[] nums, int length, int begin, int end,int[][] cache) {
            //回归条件，问题分解到最小子问题
            if (begin+1 >=end ) {//相邻的两个中间没有气球，还没进行插入
                return 0;
            }
            //缓存，避免重复计算 //保存begin - end之间的最优解
            if(cache[begin][end]!=0){
                return cache[begin][end];
            }
            //维护一个最大值
            int max = 0;
            //状态转移方程 def( i, j ) = max { def( i , k ) + def( k , j )+nums[ i ][ j ][ k ] } | i<k<j
            for (int i = begin + 1; i < end; i++) {//戳 i j 中间的气球，不包括 i，j
                int temp = maxCoins4(nums, length, begin, i,cache) +
                        maxCoins4(nums, length, i, end,cache) + nums[begin] * nums[i] * nums[end];
                if (temp > max) {
                    max = temp;
                }
            }
            //缓存，避免重复计算
            cache[begin][end]=max;
            return max;
        }
    }
    /**
     * @Author Nyr
     * @Date 2019/11/30 01:43
     * @Param
     * @Return
     * @Exception
     * @Description 动态规划解法
     */
    class Solution6 {
        public  int maxCoins4DP(int[] nums) {
            //避免空指针异常
            if (nums == null) {
                return 0;
            }
            //创建虚拟边界
            int length = nums.length;
            int[] nums2 = new int[length + 2];
            System.arraycopy(nums, 0, nums2, 1, length);
            nums2[0] = 1;
            nums2[length + 1] = 1;
            length = nums2.length;

            //创建dp表
            length = nums2.length;
            int[][] dp = new int[length][length];
//            令 dp[i][j] 表示填满开区间 (i,j)能得到的最多硬币数，
            //开始dp：i为begin，j为end，k为在i、j区间划分子问题时的边界
            for (int i = length - 2; i > -1; i--) {
                for (int j = i + 2; j < length; j++) {
                    //维护一个最大值；如果i、j相邻，值为0
                    int max = 0;
                    for (int k = i + 1; k < j; k++) {
                        int temp = dp[i][k] + dp[k][j] + nums2[i] * nums2[k] * nums2[j];
                        if (temp > max) {
                            max = temp;
                        }
                    }
                    dp[i][j] = max;
                }
            }
            return dp[0][length - 1]; }}
    class solution7{
            public int maxCoins(int[] nums) {
                if (nums==null||nums.length==0) return 0;
                int length=nums.length;
                //创建虚拟的边界
                int[] nums2=new int[length+2];
                System.arraycopy(nums,0,nums2,1,length);
                length+=2;
                nums2[0]=1;
                nums2[length-1]=1;
                //创建dp表
                int[][] dp=new int[length][length];
                //            令 dp[i][j] 表示填满开区间 (i,j)能得到的最多硬币数，
                //开始dp：i为begin，j为end，k为在i、j区间划分子问题时的边界
                for(int i=length-2;i>-1 ;i--){//一行一行填写 从右到左
                    for(int j=i+2;j<length ;j++){//
                        int max=0;
                        for(int k=i+1;k<j ;k++){
                            int tem=dp[i][k]+dp[k][j]+nums2[i]*nums2[k]*nums2[j];
                            if (tem>max){
                                max=tem;
                            }
                        }
                        dp[i][j]=max;

                    }

                }

                //
                return dp[0][length-1];

            }
    }
}
