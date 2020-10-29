package com.LeetCodeDayCourse;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/4 15:39
 * # @version 1.0
 * # @File : 下一个排列313.java
 * # @Software: IntelliJ IDEA
 */
public class 下一个排列31 {
    class Solution {
        public void nextPermutation(int[] nums) {
            int i=nums.length-2;
            while (i>=0&&nums[i]>=nums[i+1]){//从右往左找到第一个左边比右边大的值，3 4 6 < 9 < 8 <  7 <  5 < 2 < 1
                i--;
            }
            if (i>=0){//如果不是第一个，从右往左找第一个大于i的值3 4 6 -> 9 -> 8 -> 7 5 2 1
                int j = nums.length - 1;
                while (j >= 0 && nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);//交换这两个数的位置  3 4 7 9 8 6 5 2 1


            }
            reverse(nums, i + 1);
//            倒序i位置后的所有数据
//            3 4 7 1 2 5 6 8 9
//            则347125689为346987521的下一个排列
    
        }
        private void reverse(int[] nums, int start) {
            int i = start, j = nums.length - 1;
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }
    public class Solution2 {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i + 1] <= nums[i]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }

        private void reverse(int[] nums, int start) {
            int i = start, j = nums.length - 1;
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }



}
