package com.Leetcode_top100;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.lang.annotation.Target;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/15 17:04
 * # @version 1.0
 * # @File : 分割等和子集416.java
 * # @Software: IntelliJ IDEA
 */
public class 分割等和子集416 {
    class Solution {
        //方法一 递归，暴力解法，但是会超时
        public boolean canPartition(int[] nums) {
            return sublist(nums, 0, 0, 0);
        }

        public boolean sublist(int[] nums, int arr1, int arr2, int p) {
            //递归的出口
            if (p == nums.length) {
                if (arr1 == arr2) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return sublist(nums, arr1 + nums[p], arr2, p + 1) || sublist(nums, arr1, arr2 + nums[p], p + 1);

            }

        }
    }


    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));

    }


    //方法二 动态规划
    //关键是 选择n个数，和正好为整个数组的1/2，转化为0/1背包问题


    public static boolean canPartition(int[] nums) {
        int sum = 0;
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            sum += nums[i];

        }
        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] condition = new boolean[nums.length][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            condition[0][nums[0]] = true;
        }
//            for(int i=0;i<nums.length ;i++){
//            condition[i][0]=false;
//            }//默认为false，可以省略
        //从第二行还是填写表
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (nums[i] == j) {
                    condition[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    condition[i][j] = condition[i - 1][j - nums[i]] || condition[i - 1][j];
                }
            }
        }
        return condition[len-1][target];

    }


}