package com.虾皮面试;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/21
 * @Version 1.0
 **/
public class 在排序数组中查找元素的第一个和最后一个位置 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int n = nums.length - 1;
            int left = 0;
            int right = n;
            int first, last;
            while (left <= right) {

                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    // 搜索区间变为 [mid+1, right]
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    // 搜索区间变为 [left, mid-1]
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    // 收缩右侧边界
                    right = mid - 1;
                }
            }
// 检查出界情况
            if (left >= nums.length || nums[left] != target) {
                first = -1;
            } else {
                first = left;
            }

            //寻找右边界
            left = 0;
            right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    // 别返回，锁定右侧边界
                    left = mid + 1;
                }
            }
            // 最后要检查 right 越界的情况
            if (right < 0 || nums[right] != target)
                last = -1;
            else {
                last = right;
            }
            int[] res = new int[2];
            res[0] = first;
            res[1] = last;
            return res;
        }
    }
}