package com.虾皮面试;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/21
 * @Version 1.0
 **/
public class 二分查找 {
    class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;
            return binarySearch(nums, 0, n - 1, target);
        }

        private int binarySearch(int[] nums, int i, int n, int target) {
            if (i >= n) {
                if (nums[i] == target) return i;
                else return -1;
            }
            int mid = i + (n - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return binarySearch(nums, 0, mid - 1, target);
            } else return binarySearch(nums, mid + 1, n, target);
        }
    }

    public int search(int[] nums, int target) {
        int n = nums.length - 1;
        int left = 0;
        int right = n;
        int mid;
        while (left <= right) {

            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;

    }
}
