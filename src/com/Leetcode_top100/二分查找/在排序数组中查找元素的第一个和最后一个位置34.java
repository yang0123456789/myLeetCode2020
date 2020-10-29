package com.Leetcode_top100.二分查找;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/21 9:45
 * # @version 1.0
 * # @File : 在排序数组中查找元素的第一个和最后一个位置34.java
 * # @Software: IntelliJ IDEA
 * 　>> :
 * <p>
 * 　　　　负数右移用1补位
 * <p>
 * 　　　　正数右移用0补位
 * <p>
 * 　　>>>:
 * <p>
 * 　　　　无论正负，都用0补位
 */
public class 在排序数组中查找元素的第一个和最后一个位置34 {
    class Solution {
        //这里的二分法，用的全部都是闭区间，搜索的范围为【left，right】，【left，mid】【left，mid】
        // returns leftmost (or rightmost) index at which `target` should be
        // inserted in sorted array `nums` via binary search.
        private int leftBound(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length-1;


            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] == target) {
                    hi = mid - 1;
                } else if (nums[mid] > target) {
                    hi = mid - 1;
                } else if (nums[mid] < target) {
                    lo = mid + 1;
                }


            }
            if (lo >= nums.length || nums[lo] != target)
                return -1;
            return lo;
        }
        private int rightBound(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length-1;

            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] == target) {
                    lo = mid + 1;
                } else if (nums[mid] > target) {
                    hi = mid - 1;
                } else if (nums[mid] < target) {
                    lo = mid + 1;
                }


            }
            // 最后要检查 right 越界的情况
            if (hi < 0 || nums[hi] != target)
                return -1;
            return hi;
        }
        public int[] searchRange(int[] nums, int target) {
            int[] targetRange = {-1, -1};
            if (nums.length<=1) return targetRange;


            int leftIdx = leftBound(nums, target);
            if(leftIdx==-1) return targetRange;
            targetRange[0] = leftIdx;
            targetRange[1] = rightBound(nums, target) ;

            return targetRange;
        }
    }
}

