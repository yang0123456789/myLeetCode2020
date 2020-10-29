package com.Leetcode_top100;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/18 9:30
 * # @version 1.0
 * # @File : 零钱兑换322.java
 * # @Software: IntelliJ IDEA
 */
public class 零钱兑换322 {
    public class Solution {

        public int coinChange(int[] coins, int amount) {
            return coinChange(0, coins, amount);
        }

        private int coinChange(int idxCoin, int[] coins, int amount) {
            if (amount == 0)
                return 0;
            if (idxCoin < coins.length && amount > 0) {
                int maxVal = amount / coins[idxCoin];
                int minCost = Integer.MAX_VALUE;
                for (int x = 0; x <= maxVal; x++) {
                    if (amount >= x * coins[idxCoin]) {
                        int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                        if (res != -1)
                            minCost = Math.min(minCost, res + x);
                    }
                }
                return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
            }
            return -1;
        }
    }


    class Solution2 {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;
            if (coins.length == 0) return -1;
            Arrays.sort(coins);
            int[][] result = new int[coins.length][amount + 1];//创建一个二维数组，int[coin][total]表示在有这coin种硬币的情况下，最少需要几个组成total
            for (int i = 1; i < amount + 1; i++) {//填写第一行
                if (i % coins[0] == 0) {
                    result[0][i] = i / coins[0];
                } else {
                    result[0][i] = -1;
                }
            }
            for (int i = 1; i < coins.length; i++) {//一行一行的填写
                for (int j = 1; j < amount + 1; j++) {
                    result[i][j] = coins(coins, i, j, result, amount);

                }

            }
            return result[coins.length - 1][amount + 1];

        }

        public int coins(int[] coins, int i, int j, int[][] result, int amount) {
            int min = -1;
            int n = j / coins[i];
            while (n >= 0) {//贪心算法
                int les = result[i - 1][j - n * coins[i]];//看剩余的部分能不能凑成
                if (les != -1) {//如果能凑成，更改min的值
                    if (min == -1) {//min还没被更新过，直接更新
                        min = les + n;
                    } else {
                        min = Math.min(min, les + n);
                    }
                }
                n--;

            }
            return min;
        }
    }

    public class Solution4 {
        //从大硬币递归到小硬币
        public int coinChange(int[] coins, int amount) {
            if (amount < 1) return 0;
            return coinChange(coins, amount, new int[amount]);
        }

        private int coinChange(int[] coins, int rem, int[] count) {//rem表示要凑成的金额。count数组记录这个金额-1为下标下需要最少的硬币
            if (rem < 0) return -1;
            if (rem == 0) return 0;
            if (count[rem - 1] != 0) return count[rem - 1];//如果count记录了这个金额需要的最小面值，就直接返回
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = coinChange(coins, rem - coin, count);//如果递归返回的需要的硬币是有效值 既不是-1，更新min的值
                if (res >= 0 && res < min)
                    min = 1 + res;
            }
            count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;//如果min的值是被更新过的有效值，就记录下来，如果没有被更新过，说明凑不成
            return count[rem - 1];//返回计算的结果
        }
    }

    public class Solution5 {
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);//填充最大值，方便比较
            dp[0] = 0;//钱数为0的时候，最少只需0个硬币
            for (int i = 1; i <= amount; i++) {//一列一列填写，压缩了空间，从0到amount，每一轮填写完成以后，dp存储的都是当前金额下所有的硬币的最优解，直接传递到下一个循环了
                for (int j = 0; j < coins.length; j++) {//从第一个硬币开始找最小的
                    if (coins[j] <= i) {//硬币的面值比需要的小，可以尝试更新
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);//只加一个当前操作的硬币，进行更新
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }

    public class Solution6 {

        public int coinChange(int[] coins, int amount) {
            if (amount<1) return 0;
            int[] dp=new int[amount+1];
            Arrays.fill(dp,amount+1);
            dp[0] = 0;//钱数为0的时候，最少只需0个硬币
            for(int i=1;i<=amount ;i++){//钱数为0的位置肯定是0
                for(int j=0;j<coins.length;j++){
                    if (coins[j]<=i){
                        dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                    }
                }

            }
            return dp[amount]>amount?-1:dp[amount];//如果dp[amount]的值没有被更新过，直接返回-1。

        }
    }
//    暴力+剪枝
class Solution7 {
    int res = Integer.MAX_VALUE;//记录最小的硬币数目，初始化为最大值，方面比较
    public int coinChange(int[] coins, int amount){
        if(amount==0){
            return 0;
        }
        Arrays.sort(coins);
        mincoin(coins,amount,coins.length-1,0);
        return res==Integer.MAX_VALUE? -1:res;
    }
    //amount 剩余的钱币数目
    //count记录已经有多少个硬币了
    private void mincoin(int[] coins,int amount, int index, int count){
        if(amount==0){//递归到头了，很成功，跟新最小硬币数
            res = Math.min(res,count);
            return;
        }
        if(index<0){//index已经到头了，还没遍历完，说明没有求出
            return;
        }
        for(int i = amount/coins[index];i>=0 && i+count<res; i--){//贪心算法，从最大值硬币最多的数目开始遍历，看能不能凑成
            mincoin(coins,amount - (i*coins[index]), index-1, count+i);
        }
    }
}
}
