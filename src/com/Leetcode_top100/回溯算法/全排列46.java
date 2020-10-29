package com.Leetcode_top100.回溯算法;

import sun.security.util.Length;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/21 17:00
 * # @version 1.0
 * # @File : 全排列46.java
 * # @Software: IntelliJ IDEA
 */
public class 全排列46 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            int len=nums.length;
            List<List<Integer>> ans=new ArrayList<>();
            if (len<=0) return ans;
            boolean[] used=new boolean[len];
            dfs(ans,nums,  len, 0,new ArrayDeque<>(),used);
            return ans;

        }
        //ans 保存的结果
        //level 第几层 path:保存的路径
//        Len路径的总长度

        public void dfs(List<List<Integer>> ans,int[] nums, int len,int depth, Deque<Integer> path,boolean[] used){

            if (depth==len){
                ans.add(new ArrayList<>(path));
                return;
            }
            for(int i=0;i<len ;i++){
                if (used[i]){
                    continue;
                }
                used[i]= true;
                path.addLast(nums[i]);
                dfs(ans,nums,  len, depth+1,path,used);
                path.removeLast();
                used[i]=false;


            }
        }
    }
}
