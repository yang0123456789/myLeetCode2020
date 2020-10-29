package com.LeetCode_jianzhioffer.FindContinuousSequence41;

import java.util.ArrayList;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/16 15:47
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {


        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if (sum==0) return result;
        for(int i=1;i<=100 ;i++){
            if (i>=sum)break;
            int count=0;
            ArrayList<Integer> nums=new ArrayList<>();
            for(int j=i;i<=sum ;j++){
                if (j==sum)break;
                count=count+j;
                nums.add(j);
                if (count==sum){
                    result.add(nums);
                    break;
                }
                if (count>sum)break;

            }

        }
        return result;
    }
}
