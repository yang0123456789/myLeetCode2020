package com.Leetcode_top100;

import com.yang.juc.conditionThread.CountryEnum;

import java.util.HashMap;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/14 10:05
 * # @version 1.0
 * # @File : 和为K的子数组560.java
 * # @Software: IntelliJ IDEA
 */
public class 和为K的子数组560 {
    //暴力解法 ，两个循环，ij表示子序列范围，看子序列的和是不是k。是的话+1，不是的话，继续，遍历所有可能的组合
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int res=0;
            for(int i=0;i<nums.length ;i++){
                int sum=0;
                for(int j=i;j<nums.length ;j++){
                    //求和i到j范围内
                   sum=sum+nums[j];
                    if (sum==k){
                        res++;
                    }

                }

            }


            return res;
        }
    }
    public class Solution2 {
        public int subarraySum(int[] nums, int k) {
            //哈希表+前缀法
            int count = 0, pre = 0;
            HashMap< Integer, Integer > mp = new HashMap < > ();
            mp.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                if (mp.containsKey(pre - k))
                    count += mp.get(pre - k);
                mp.put(pre, mp.getOrDefault(pre, 0) + 1);
            }
            return count;
        }
    }

}
