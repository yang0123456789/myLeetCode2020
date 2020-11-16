package com.二刷leetcode核心题目.DFS;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/15 21:25
 * # @version 1.0
 * # @File : 目标和_494.java
 * # @Software: IntelliJ IDEA
 */
public class 目标和_494 {
    public  int count=0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums,S,nums.length,0,0);
        return count;

    }
    public  void dfs(int[] nums, int S,int len,int now,int total){
        if (now==len){
            if (total==S)count++;
        }else {
            dfs(nums,S,len,now+1,total-nums[now]);
            dfs(nums,S,len,now+1,total+nums[now]);
        }


    }
}
