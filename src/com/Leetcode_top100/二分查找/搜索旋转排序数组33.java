package com.Leetcode_top100.二分查找;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/21 9:06
 * # @version 1.0
 * # @File : 搜索旋转排序数组33.java
 * # @Software: IntelliJ IDEA
 */
public class 搜索旋转排序数组33 {
    class Solution {
        public int search(int[] nums, int target) {

            int n = nums.length;
            if (n == 0) return -1;
            if (n == 1) return nums[0] == target ? 0 : -1;

            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) return mid;
                // 左半边有序
                if (nums[0] <= nums[mid]) {
                    // target的值在左半边
                    if (nums[0] <= target && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }// 右半边有序
                else {
                    // target的值在右半边
                    if (nums[mid] < target && target <= nums[n - 1]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

}
