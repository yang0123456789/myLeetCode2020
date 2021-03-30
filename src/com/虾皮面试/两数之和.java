package com.虾皮面试;

import java.util.Arrays;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/25
 * @Version 1.0
 **/
public class 两数之和 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int m=0,n=0,k,board=0;
            int[] res=new int[2];
            int[] tmp1=new int[nums.length];
            System.arraycopy(nums,0,tmp1,0,nums.length);
            Arrays.sort(nums);
            for(int i=0,j=nums.length-1;i<j;){
                if(nums[i]+nums[j]<target)
                    i++;
                else if(nums[i]+nums[j]>target)
                    j--;
                else if(nums[i]+nums[j]==target){
                    m=i;
                    n=j;
                    break;
                }
            }
            for(k=0;k<nums.length;k++){
                if(tmp1[k]==nums[m]){
                    res[0]=k;
                    break;
                }
            }
            for(int i=0;i<nums.length;i++){
                if(tmp1[i]==nums[n]&&i!=k)
                    res[1]=i;
            }
            return res;
        }
    }


}
